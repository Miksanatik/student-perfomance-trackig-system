package by.gsu.asoilab;

import by.gsu.asoilab.courses.Course;
import by.gsu.asoilab.courses.CourseCategories;
import by.gsu.asoilab.courses.CourseFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTest {

    @Test
    void getStudentId() {
        Progress progress = new Progress.Builder()
                .setStudent(new Student.Builder().build())
                .build();
        Student student = new Student.Builder().build();
        assertEquals(student, progress.getStudent());
    }

    @Test
    void getCourse() {
        Progress progress = new Progress.Builder()
                .setCourse(new CourseFactory.Builder().setCategory(CourseCategories.MATH).build())
                .build();
        Course course = new CourseFactory.Builder().setCategory(CourseCategories.MATH).build();
        assertEquals(course, progress.getCourse());
    }

    @Test
    void getControlPoints() {
        int[] controlPoints = {100, 158, 205, 79, 147};
        Progress progress = new Progress.Builder().setControlPoints(controlPoints).build();
        assertEquals(controlPoints, progress.getControlPoints());
    }

    @Test
    void testToString() {
        int[] controlPoints = {100, 158, 205, 79, 147};
        Progress progress = new Progress.Builder()
                .setStudent(new Student.Builder().setId(1).build())
                .setCourse(new CourseFactory.Builder().setId(3).setCategory(CourseCategories.BIOLOGY).build())
                .setControlPoints(controlPoints)
                .build();
        assertEquals("1;3;[100, 158, 205, 79, 147]", progress.toString());
    }

    @Test
    void testGetTotalPoints() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        List<Achievement> achievements = Arrays.asList(
                new Achievement.Builder()
                        .setRequiredPoints(85)
                        .setTestNo(1)
                        .setEarnedPoints(50)
                        .build(),
                new Achievement.Builder()
                        .setRequiredPoints(90)
                        .setTestNo(4)
                        .setEarnedPoints(75)
                        .build()
        );
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .setCourse(new CourseFactory.Builder()
                        .setCategory(CourseCategories.PROGRAMMING)
                        .setAchievements(achievements)
                        .build())
                .build();
        assertEquals(270 + 50, progress.getTotalPoints());
    }

    @Test
    void testGetAveragePoint() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .build();
        assertEquals(54, progress.getAveragePoint());
    }

    @Test
    void testGetMaxPoint() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .build();
        assertEquals(100, progress.getMaxPoint());
    }

    @Test
    void testGetMinPoint() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .build();
        assertEquals(20, progress.getMinPoint());
    }

    @Test
    void testGetIsPassed() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        List<Achievement> achievements = Arrays.asList(
                new Achievement.Builder()
                        .setRequiredPoints(85)
                        .setTestNo(1)
                        .setEarnedPoints(50)
                        .build(),
                new Achievement.Builder()
                        .setRequiredPoints(90)
                        .setTestNo(4)
                        .setEarnedPoints(75)
                        .build()
        );
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .setCourse(new CourseFactory.Builder()
                        .setCategory(CourseCategories.PROGRAMMING)
                        .setAchievements(achievements)
                        .setThresholdPoints(400)
                        .setPointsToHonors(420)
                        .build())
                .build();
        assertFalse(progress.isPassed());
    }

    @Test
    void testGetIsPassedWithHonors() {
        int[] controlPoints = {100, 20, 30, 50, 70};
        List<Achievement> achievements = Arrays.asList(
                new Achievement.Builder()
                        .setRequiredPoints(85)
                        .setTestNo(1)
                        .setEarnedPoints(50)
                        .build(),
                new Achievement.Builder()
                        .setRequiredPoints(90)
                        .setTestNo(4)
                        .setEarnedPoints(75)
                        .build()
        );
        Progress progress = new Progress.Builder()
                .setControlPoints(controlPoints)
                .setCourse(new CourseFactory.Builder()
                        .setCategory(CourseCategories.PROGRAMMING)
                        .setAchievements(achievements)
                        .setThresholdPoints(400)
                        .setPointsToHonors(420)
                        .build())
                .build();
        assertFalse(progress.isPassedWithHonors());
    }
}