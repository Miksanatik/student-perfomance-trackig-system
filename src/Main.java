import by.gsu.asoilab.*;
import by.gsu.asoilab.courses.Course;
import by.gsu.asoilab.courses.CourseCategories;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                DatabaseConnection db = DatabaseConnection.getInstance();
                connection = db.getConnection();
                // Create a statement
                statement = connection.createStatement();
                // Execute SQL query
                String query = "SELECT * FROM Students";
                resultSet = statement.executeQuery(query);
                // Process the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nickname") + " " +
                            resultSet.getString("country") + " " +
                            resultSet.getInt("age") + " " +
                            resultSet.getString("gender")
                    );
                }
            } finally {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }

            System.out.println();
            Course course = new CourseFactory.Builder()
                    .setId(1)
                    .setName("Python")
                    .setCategory(CourseCategories.PROGRAMMING)
                    .setThresholdPoints(225)
                    .setPointsToHonors(290)
                    .build();

            System.out.println(course);

            System.out.println();
            Student student = new Student.Builder()
                    .setNickname("Alina")
                    .setAge(19)
                    .setCountry("Belarus")
                    .setGender(Gender.FEMALE)
                    .setId(1)
                    .build();
            System.out.println(student);
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }
}

