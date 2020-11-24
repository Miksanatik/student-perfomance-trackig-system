import java.sql.*;
import java.util.ArrayList;
import by.gsu.asoilab.*;


public class Main {

    public static void main(String[] args) {
        String databaseURL = "jdbc:ucanaccess://course_database.accdb";

        try {
            Connection connection = DriverManager.getConnection(databaseURL);

            System.out.println("Connected to MS Access database!");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Students";
            ResultSet result = statement.executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();

            while (result.next()) {
                students.add(new Student(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4)));
            }

            for (Student student : students) {
                System.out.println(student);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
}