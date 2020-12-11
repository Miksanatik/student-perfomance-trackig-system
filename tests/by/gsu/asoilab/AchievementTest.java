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
    void getRequiredPoints() {
        Achievement achievement = new Achievement.Builder().setRequiredPoints(100).build();
        assertEquals(100, achievement.getRequiredPoints());
    }

    @Test
    void getEarnedPoints() {
        Achievement achievement = new Achievement.Builder().setEarnedPoints(50).build();
        assertEquals(50, achievement.getEarnedPoints());
    }

    @Test
    void getTestNo() {
        Achievement achievement = new Achievement.Builder().setTestNo(1).build();
        assertEquals(1, achievement.getTestNo());
    }

    @Test
    void testToString() {
        Achievement achievement = new Achievement.Builder()
                .setId(5)
                .setName("JavaExpert")
                .setRequiredPoints(100)
                .setTestNo(1)
                .setEarnedPoints(50)
                .build();
        assertEquals("5;JavaExpert;100;1;50", achievement.toString());
    }
}