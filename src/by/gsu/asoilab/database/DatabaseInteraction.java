package by.gsu.asoilab.database;

import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.Course;
import by.gsu.asoilab.courses.CourseCategories;
import by.gsu.asoilab.courses.CourseFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInteraction {
    private static Connection cn;

    static {
        try {
            cn = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    public List<Student> readStudentsFromDd() {
        List<Student> students = new ArrayList<>();
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                students.add(new Student.Builder()
                        .setId(rs.getInt(1))
                        .setNickname(rs.getString(2))
                        .setCountry(rs.getString(3))
                        .setAge(rs.getInt(4))
                        .setGender(Gender.valueOf(rs.getString(5)))
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return students;
    }

    public List<Achievement> readAchievementsFromDb() {
        List<Achievement> achievements = new ArrayList<>();
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM achievements")) {
            while (rs.next()) {
                achievements.add(new Achievement.Builder()
                        .setId(rs.getInt(1))
                        .setName(rs.getString(2))
                        .setPoints(rs.getInt(3))
                        .setTestNo(rs.getInt(4))
                        .setCourseId(rs.getInt(5))
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return achievements;
    }

    public List<Course> readCoursesFromDb() {
        List<Course> courses = new ArrayList<>();
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM courses"))  {
            while (rs.next()) {
                courses.add(new CourseFactory.Builder()
                        .setCategory(CourseCategories.valueOf(rs.getString(5)))
                        .setId(rs.getInt(1))
                        .setName(rs.getString(2))
                        .setThresholdPoints(rs.getInt(3))
                        .setPointsToHonors(rs.getInt(4))
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return courses;
    }

    public List<Progress> readProgressFromDb() {
        List<Progress> progresses = new ArrayList<>();
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM progress")) {
            while (rs.next()) {
                progresses.add(new Progress.Builder()
                        .setStudentId(rs.getInt(1))
                        .setCourseId(rs.getInt(2))
                        .setControlPoints(new int[]{rs.getInt(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getInt(6),
                                rs.getInt(7)})
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return progresses;
    }

}
