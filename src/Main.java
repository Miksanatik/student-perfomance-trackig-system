import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.*;
import by.gsu.asoilab.database.DatabaseConnection;
import by.gsu.asoilab.database.DatabaseInteraction;
import by.gsu.asoilab.graphics.DotPlot;
import by.gsu.asoilab.graphics.Graphic;
import by.gsu.asoilab.graphics.Histogram;
import by.gsu.asoilab.graphics.PieChart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (Connection cn = DatabaseConnection.getInstance().getConnection()) {
//            System.out.println("Students:");
            List<Student> students = DatabaseInteraction.readStudentsFromDd(cn);
//            for (Student student : students) {
//                System.out.println(student);
//            }

//            System.out.println("\nAchievements:");
            List<Achievement> achievements = DatabaseInteraction.readAchievementsFromDb(cn);
//            for (Achievement achievement : achievements) {
//                System.out.println(achievement);
//            }

//            System.out.println("\nCourses:");
            List<Course> courses = DatabaseInteraction.readCoursesFromDb(cn, achievements);
//            for (Course course : courses) {
//                System.out.println(course);
//            }

//            System.out.println("\nProgresses:");
            List<Progress> progresses = DatabaseInteraction.readProgressFromDb(cn, courses, students);
//            for (Progress progress : progresses) {
//                System.out.println(progress);
//            }
            Graphic graphic = new DotPlot();
            graphic.create(progresses.get(0).getControlPoints(),
                    "Results graph: "+
                    progresses.get(0).getStudent().getNickname());

            int[] mass = new int[]{75,25,70,55,14,20};
            Graphic graphic1 = new Histogram();
            graphic1.create(mass,"Histogram of results");

            int[] mass2 = new int[]{2,12,18};
            Graphic graphic2 = new PieChart();
            graphic2.create(mass2,"Pie");

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
}