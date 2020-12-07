package by.gsu.asoilab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AchievementTest {

    @Test
    void getId() {
        Achievement achievement = new Achievement.Builder().setId(5).build();
        assertEquals(5, achievement.getId());
    }

    @Test
    void getName() {
        Achievement achievement = new Achievement.Builder().setName("JavaExpert").build();
        assertEquals("JavaExpert", achievement.getName());
    }

    @Test
    void getPoints() {
        Achievement achievement = new Achievement.Builder().setPoints(100).build();
        assertEquals(100, achievement.getPoints());
    }

    @Test
    void getTestNo() {
        Achievement achievement = new Achievement.Builder().setTestNo(1).build();
        assertEquals(1, achievement.getTestNo());
    }

    @Test
    void getCourseId() {
        Achievement achievement = new Achievement.Builder().setCourseId(2).build();
        assertEquals(2, achievement.getCourseId());
    }

    @Test
    void testToString() {
        Achievement achievement = new Achievement.Builder()
                .setId(5)
                .setName("JavaExpert")
                .setPoints(100)
                .setTestNo(1)
                .setCourseId(2)
                .build();
        assertEquals("5;JavaExpert;100;1;2", achievement.toString());
    }
}