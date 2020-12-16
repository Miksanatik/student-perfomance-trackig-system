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
            DatabaseInteraction db = new DatabaseInteraction(cn);

            List<Student> students = db.readStudentsFromDd();
            List<Achievement> achievements = db.readAchievementsFromDb();
            List<Course> courses = db.readCoursesFromDb(achievements);
            List<Progress> progresses = db.readProgressFromDb(courses, students);

            Scanner in = new Scanner(System.in);
            int num = 0;
            while (true) {
                System.out.println("1: Output list of student \n" +
                        "2: Output histogram by gender\n" +
                        "3: Output pie chart\n" +
                        "4: Output dot plot by student\n" +
                        "5: Information about student\n" +
                        "6: Exit");
                System.out.print("Enter a number: ");
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
        for (Progress progress : progresses) {
            if (progress.getStudent().getGender().equals(Gender.M)) {
                if (results[0] < progress.getMaxPoint())
                    results[0] = progress.getMaxPoint();
                if (results[1] > progress.getMinPoint())
                    results[1] = progress.getMinPoint();
                avgM += progress.getAveragePoint();
                ++countM;
            }
            if (progress.getStudent().getGender().equals(Gender.F)) {
                if (results[3] < progress.getMaxPoint())
                    results[3] = progress.getMaxPoint();
                if (results[4] > progress.getMinPoint())
                    results[4] = progress.getMinPoint();
                avgF += progress.getAveragePoint();
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
        for (Progress progress : progresses) {
            if (progress.isPassedWithHonors()) {
                ++results[0];
            } else if (progress.isPassed()) {
                ++results[1];
            } else
                ++results[2];
        }
        Graphic pieChart = new PieChart();
        pieChart.create(results, "Results");

    }

    public static void showDotPlot(List<Progress> progresses, int size, Scanner in) {
        System.out.print("Enter ID of student: ");
        int id = in.nextInt();
        if (id < size) {
            for (Progress progress : progresses) {
                if (progress.getStudent().getId() == id) {
                    Graphic dotPlot = new DotPlot();
                    dotPlot.create(progress.getControlPoints(), progress.getStudent().getNickname() + ": " + progress.getCourse().getName());
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
        for (Progress progress : progresses) {
            if (progress.getStudent().getId() == id) {
                System.out.print(progress.getStudent().getNickname() + "; " +
                        progress.getCourse().getName() + "; Points: " +
                        progress.getTotalPoints());
                if (progress.isPassedWithHonors())
                    System.out.println("; Passed with honors");
                else if (progress.isPassed())
                    System.out.println("; Passed");
                else
                    System.out.println("; Didn't passed");

            }
        }
    }
}