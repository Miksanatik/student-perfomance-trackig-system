package by.gsu.asoilab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getId() {
        Student student = new Student.Builder().setId(1).build();
        assertEquals(1, student.getId());
    }

    @Test
    void getNickname() {
        Student student = new Student.Builder().setNickname("Paul").build();
        assertEquals("Paul", student.getNickname());
    }

    @Test
    void getCountry() {
        Student student = new Student.Builder().setCountry("USA").build();
        assertEquals("USA", student.getCountry());
    }

    @Test
    void getGender() {
        Student student = new Student.Builder().setGender(Gender.MALE).build();
        assertEquals(Gender.MALE, student.getGender());
    }

    @Test
    void getAge() {
        Student student = new Student.Builder().setAge(20).build();
        assertEquals(20, student.getAge());
    }

    @Test
    void testToString() {
        Student student = new Student.Builder()
                .setId(1)
                .setNickname("Paul")
                .setCountry("USA")
                .setGender(Gender.MALE)
                .setAge(20)
                .build();
        assertEquals("1;Paul;USA;Male;20", student.toString());
    }
}