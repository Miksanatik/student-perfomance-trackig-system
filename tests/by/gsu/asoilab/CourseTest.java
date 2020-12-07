package by.gsu.asoilab;

import by.gsu.asoilab.courses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course programmingCourse = new ProgrammingCourse(1,
            "Python",
            250,
            275
    );
    Course mathCourse = new MathCourse(2,
            "Probability",
            325,
            335
    );
    Course biologyCourse = new BiologyCourse(3,
            "Anatomy",
            480,
            495
    );
    Course physicsCourse = new PhysicsCourse(4,
            "Mechanics",
            420,
            435
    );

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
    void getPointsToPassWithHonors() {
        assertEquals(25, programmingCourse.getPointsToPassWithHonors());
        assertEquals(10, mathCourse.getPointsToPassWithHonors());
        assertEquals(15, biologyCourse.getPointsToPassWithHonors());
        assertEquals(15, physicsCourse.getPointsToPassWithHonors());
    }

    @Test
    void testToString() {
        assertEquals("1;Python;250;275", programmingCourse.toString());
        assertEquals("2;Probability;325;335", mathCourse.toString());
        assertEquals("3;Anatomy;480;495", biologyCourse.toString());
        assertEquals("4;Mechanics;420;435", physicsCourse.toString());
    }
}