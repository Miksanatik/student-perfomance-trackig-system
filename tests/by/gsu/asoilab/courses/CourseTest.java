package by.gsu.asoilab.courses;

import by.gsu.asoilab.Achievement;
import by.gsu.asoilab.courses.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    List<Achievement> achievements = Arrays.asList(
            new Achievement.Builder()
                    .setId(1)
                    .setName("Good start")
                    .setRequiredPoints(85)
                    .setTestNo(1)
                    .setEarnedPoints(50)
                    .build(),
            new Achievement.Builder()
                    .setId(2)
                    .setName("Successful student")
                    .setRequiredPoints(90)
                    .setTestNo(4)
                    .setEarnedPoints(75)
                    .build()
    );

    Course programmingCourse = new CourseFactory.Builder()
            .setId(1)
            .setName("Python")
            .setThresholdPoints(250)
            .setPointsToHonors(275)
            .setAchievements(achievements)
            .setCategory(CourseCategories.PROGRAMMING)
            .build();

    Course mathCourse = new CourseFactory.Builder()
            .setId(2)
            .setName("Probability")
            .setThresholdPoints(325)
            .setPointsToHonors(335)
            .setAchievements(achievements)
            .setCategory(CourseCategories.MATH)
            .build();

    Course biologyCourse = new CourseFactory.Builder()
            .setId(3)
            .setName("Anatomy")
            .setThresholdPoints(480)
            .setPointsToHonors(495)
            .setAchievements(achievements)
            .setCategory(CourseCategories.BIOLOGY)
            .build();

    Course physicsCourse = new CourseFactory.Builder()
            .setId(4)
            .setName("Mechanics")
            .setThresholdPoints(420)
            .setPointsToHonors(435)
            .setAchievements(achievements)
            .setCategory(CourseCategories.PHYSICS)
            .build();

    @Test
    void getId() {
        assertEquals(1, programmingCourse.getId());
        assertEquals(2, mathCourse.getId());
        assertEquals(3, biologyCourse.getId());
        assertEquals(4, physicsCourse.getId());
    }

    @Test
    void getName() {
        assertEquals("Python", programmingCourse.getName());
        assertEquals("Probability", mathCourse.getName());
        assertEquals("Anatomy", biologyCourse.getName());
        assertEquals("Mechanics", physicsCourse.getName());
    }

    @Test
    void getThreshold() {
        assertEquals(250, programmingCourse.getThresholdPoints());
        assertEquals(325, mathCourse.getThresholdPoints());
        assertEquals(480, biologyCourse.getThresholdPoints());
        assertEquals(420, physicsCourse.getThresholdPoints());
    }

    @Test
    void getPointsToHonors() {
        assertEquals(275, programmingCourse.getPointsToHonors());
        assertEquals(335, mathCourse.getPointsToHonors());
        assertEquals(495, biologyCourse.getPointsToHonors());
        assertEquals(435, physicsCourse.getPointsToHonors());
    }

    @Test
    void testGetAchievements() {
        assertEquals(achievements, programmingCourse.getAchievements());
        assertEquals(achievements, mathCourse.getAchievements());
        assertEquals(achievements, biologyCourse.getAchievements());
        assertEquals(achievements, physicsCourse.getAchievements());
    }

    @Test
    void testCalculateTotalPoints() {
        int summaryPoints = 300;
        int achievedPoints = 20;
        assertEquals(summaryPoints + achievedPoints,
                programmingCourse.calculateTotalPoints(summaryPoints, achievedPoints));
        assertEquals(0.9 * summaryPoints + 0.8 * achievedPoints,
                mathCourse.calculateTotalPoints(summaryPoints, achievedPoints));
        assertEquals(summaryPoints + 0.75 * achievedPoints,
                biologyCourse.calculateTotalPoints(summaryPoints, achievedPoints));
        assertEquals(0.85 * summaryPoints + achievedPoints,
                physicsCourse.calculateTotalPoints(summaryPoints, achievedPoints));
    }

    @Test
    void testToString() {
        assertEquals("1;Python;250;275", programmingCourse.toString());
        assertEquals("2;Probability;325;335", mathCourse.toString());
        assertEquals("3;Anatomy;480;495", biologyCourse.toString());
        assertEquals("4;Mechanics;420;435", physicsCourse.toString());
    }
}