import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.Course;
import by.gsu.asoilab.database.DatabaseInteraction;
import by.gsu.asoilab.graphics.Graphic;
import by.gsu.asoilab.graphics.DotPlot;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseInteraction db = new DatabaseInteraction();

        System.out.println("Students:");
        List<Student> students = db.readStudentsFromDd();
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nCourses:");
        List<Course> courses = db.readCoursesFromDb();
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.println("\nAchievements:");
        List<Achievement> achievements = db.readAchievementsFromDb();
        for (Achievement achievement : achievements) {
            System.out.println(achievement);
        }

        System.out.println("\nProgresses:");
        List<Progress> progresses = db.readProgressFromDb();
        for (Progress progress : progresses) {
            System.out.println(progress);
        }

        Graphic graphic = new DotPlot();
        graphic.create(progresses.get(0).getControlPoints());

    }
}
