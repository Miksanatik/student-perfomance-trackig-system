package by.gsu.asoilab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTest {

    @Test
    void getStudentId() {
        Progress progress = new Progress.Builder().setStudentId(1).build();
        assertEquals(1, progress.getStudentId());
    }

    @Test
    void getCourseId() {
        Progress progress = new Progress.Builder().setCourseId(3).build();
        assertEquals(3, progress.getCourseId());
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
                .setStudentId(1)
                .setCourseId(3)
                .setControlPoints(controlPoints)
                .build();
        assertEquals("1;3;[100, 158, 205, 79, 147]", progress.toString());
    }
}