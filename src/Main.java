import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.*;
import by.gsu.asoilab.database.DatabaseConnection;
import by.gsu.asoilab.database.DatabaseInteraction;
import by.gsu.asoilab.graphics.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Connection cn = DatabaseConnection.getInstance().getConnection()) {
            System.out.println("Students:");
            List<Student> students = DatabaseInteraction.readStudentsFromDd(cn);
//            for (Student student : students) {
//                System.out.println(student);
//            }
//
//            System.out.println("\nAchievements:");
            List<Achievement> achievements = DatabaseInteraction.readAchievementsFromDb(cn);
//            for (Achievement achievement : achievements) {
//                System.out.println(achievement);
//            }
//
//            System.out.println("\nCourses:");
            List<Course> courses = DatabaseInteraction.readCoursesFromDb(cn, achievements);
//            for (Course course : courses) {
//                System.out.println(course);
//            }
//
//            System.out.println("\nProgresses:");
            List<Progress> progresses = DatabaseInteraction.readProgressFromDb(cn, courses, students);
//            for (Progress progress : progresses) {
//                System.out.println(progress);
//            }

            Scanner in = new Scanner(System.in);
            int num = 0;
            while (true) {
                System.out.println("1: Output list of student \n" +
                        "2: Output histogram by gender\n" +
                        "3: Output pie chart\n" +
                        "4: Output dot plot by student\n" +
                        "5: Information about student\n" +
                        "6: Exit");
                num = in.nextInt();
                switch (num) {
                    case 1:
                        for (Student student : students) {
                            System.out.println(student);
                        }
                        break;
                    case 2:
                        showHistogram(progresses);
                        break;
                    case 3:
                        showPieChart(progresses);
                        break;
                    case 4:
                        showDotPlot(progresses, students.size(), in);
                        break;
                    case 5:
                        showInfo(progresses, in);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Incorrect number");
                        break;
                }
                System.out.println();
            }
//            Graphic graphic = new DotPlot();
//            graphic.create(progresses.get(0).getControlPoints(),
//                    "Results graph: "+
//                    progresses.get(0).getStudent().getNickname());
//
//            int[] mass = new int[]{75,25,70,55,14,20};
//            Graphic graphic1 = new Histogram();
//            graphic1.create(mass,"Histogram of results");
//
//            int[] mass2 = new int[]{2,12,18};
//            Graphic graphic2 = new PieChart();
//            graphic2.create(mass2,"Pie");

//                    Progress progress = progresses.get(0);
//                    System.out.println("\n" + progress);
//                    System.out.println("\nAverage: " + progress.getAveragePoint());
//                    System.out.println("Max: " + progress.getMaxPoint());
//                    System.out.println("Min: " + progress.getMinPoint());
//                    System.out.println("Total: " + progress.getTotalPoints());
//                    System.out.println("\nAchievements:");
//                    progress.printEarnedAchievements();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void showHistogram(List<Progress> progresses) {
        int[] results = new int[6];
        results[1] = Integer.MAX_VALUE;
        results[4] = Integer.MAX_VALUE;
        int avgF = 0;
        int avgM = 0;
        int countF = 0;
        int countM = 0;
        for (Progress prgs : progresses) {
            if (prgs.getStudent().getGender().equals(Gender.M)) {
                if (results[0] < prgs.getMaxPoint())
                    results[0] = prgs.getMaxPoint();
                if (results[1] > prgs.getMinPoint())
                    results[1] = prgs.getMinPoint();
                avgM += prgs.getAveragePoint();
                ++countM;
            }
            if (prgs.getStudent().getGender().equals(Gender.F)) {
                if (results[3] < prgs.getMaxPoint())
                    results[3] = prgs.getMaxPoint();
                if (results[4] > prgs.getMinPoint())
                    results[4] = prgs.getMinPoint();
                avgF += prgs.getAveragePoint();
                ++countF;
            }

        }
        avgF = avgF / countF;
        avgM = avgM / countM;
        results[2] = avgM;
        results[5] = avgF;
        Graphic histogram = new Histogram();
        histogram.create(results, "Histogram by gender");
    }

    public static void showPieChart(List<Progress> progresses) {
        int[] results = new int[3];
        for (Progress prgs : progresses) {
            if (prgs.isPassedWithHonors()) {
                ++results[0];
            } else if (prgs.isPassed()) {
                ++results[1];
            } else
                ++results[2];
        }
        Graphic pieChart = new PieChart();
        pieChart.create(results, "Results");

    }

    public static void showDotPlot(List<Progress> progresses, int size, Scanner in) {
        System.out.println("Enter ID of student");
        int id = in.nextInt();
        if (id < size) {
            for(Progress prgs : progresses) {
                if(prgs.getStudent().getId() == id) {
                    Graphic dotPlot = new DotPlot();
                    dotPlot.create(prgs.getControlPoints(), prgs.getStudent().getNickname() + ": " + prgs.getCourse().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else
            System.out.println("ID not found");
    }


    static void showInfo(List<Progress> progresses, Scanner in) {
        System.out.print("Enter id: ");
        int id = in.nextInt();
        for(Progress prgs : progresses) {
            if(prgs.getStudent().getId() == id) {
                System.out.print(prgs.getStudent().getNickname() + "; " +
                        prgs.getCourse().getName() + "; Points: " +
                        prgs.getTotalPoints());
                if(prgs.isPassedWithHonors())
                    System.out.println("; Passed with honors");
                else if (prgs.isPassed())
                    System.out.println("; Passed");
                else
                    System.out.println("; Didn't passed");

            }
        }
    }
}