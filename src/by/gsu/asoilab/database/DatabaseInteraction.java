package by.gsu.asoilab.database;

import by.gsu.asoilab.Achievement;
import by.gsu.asoilab.Gender;
import by.gsu.asoilab.Progress;
import by.gsu.asoilab.Student;
import by.gsu.asoilab.courses.Course;
import by.gsu.asoilab.courses.CourseCategories;
import by.gsu.asoilab.courses.CourseFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseInteraction {
    private Connection cn;

    public DatabaseInteraction(Connection cn) {
        this.cn = cn;
    }

    public List<Student> readStudentsFromDd() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                students.add(new Student.Builder()
                        .setId(rs.getInt(1))
                        .setNickname(rs.getString(2))
                        .setCountry(rs.getString(3))
                        .setAge(rs.getInt(4))
                        .setGender(Gender.valueOf(rs.getString(5)))
                        .build());
            }
        }
        return students;
    }

    public List<Achievement> readAchievementsFromDb() throws SQLException {
        List<Achievement> achievements = new ArrayList<>();
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM achievements")) {
            while (rs.next()) {
                achievements.add(new Achievement.Builder()
                        .setId(rs.getInt(1))
                        .setName(rs.getString(2))
                        .setRequiredPoints(rs.getInt(3))
                        .setTestNo(rs.getInt(4))
                        .setEarnedPoints(rs.getInt(5))
                        .build());
            }
        }
        return achievements;
    }

    public List<Course> readCoursesFromDb(List<Achievement> achievements) throws SQLException {
        List<Course> courses = new ArrayList<>();
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM courses")) {
            while (rs.next()) {
                courses.add(new CourseFactory.Builder(CourseCategories.valueOf(rs.getString(5)))
                        .setId(rs.getInt(1))
                        .setName(rs.getString(2))
                        .setThresholdPoints(rs.getInt(3))
                        .setPointsToHonors(rs.getInt(4))
                        .setAchievements(achievements)
                        .build());
            }
        }
        return courses;
    }

    public List<Progress> readProgressFromDb(List<Course> courses, List<Student> students) throws SQLException {
        Map<Integer, Course> courseById = getCourseById(courses);
        Map<Integer, Student> studentById = getStudentById(students);
        List<Progress> progresses = new ArrayList<>();
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM progress")) {
            while (rs.next()) {
                progresses.add(new Progress.Builder()
                        .setStudent(studentById.get(rs.getInt(1)))
                        .setCourse(courseById.get(rs.getInt(2)))
                        .setControlPoints(new int[]{rs.getInt(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getInt(6),
                                rs.getInt(7)})
                        .build());
            }
        }
        return progresses;
    }

    private Map<Integer, Course> getCourseById(List<Course> courses) {
        Map<Integer, Course> courseById = new HashMap<>();
        for (Course course : courses) {
            courseById.put(course.getId(), course);
        }
        return courseById;
    }

    private Map<Integer, Student> getStudentById(List<Student> students) {
        Map<Integer, Student> studentById = new HashMap<>();
        for (Student student : students) {
            studentById.put(student.getId(), student);
        }
        return studentById;
    }

}
