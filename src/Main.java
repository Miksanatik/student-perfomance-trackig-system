import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.*;
import by.gsu.asoilab.database.DatabaseInteraction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseInteraction db = new DatabaseInteraction();

        System.out.println("Students:");
        List<Student> students = db.readStudentsFromDd();
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nAchievements:");
        List<Achievement> achievements = db.readAchievementsFromDb();
        for (Achievement achievement : achievements) {
            System.out.println(achievement);
        }

        System.out.println("\nCourses:");
        List<Course> courses = db.readCoursesFromDb(achievements);
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.println("\nProgresses:");
        List<Progress> progresses = db.readProgressFromDb(courses, students);
        for (Progress progress : progresses) {
            System.out.println(progress);
        }

        Progress progress = progresses.get(0);
        System.out.println("\n"+progress);
        System.out.println("\nAverage: " + progress.getAveragePoint());
        System.out.println("Max: " + progress.getMaxPoint());
        System.out.println("Min: " + progress.getMinPoint());
        System.out.println("Total: " + progress.getTotalPoints());
        System.out.println("\nAchievements:");
        progress.printEarnedAchievements();

    }
}
