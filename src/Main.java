import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String className = "com.mysql.cj.jdbc.Driver";

        String urlBase = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "courses_db";
        String additions = "?useUnicode=true&serverTimezone=UTC";
        String dbUrl = urlBase + dbName + additions;

        String username = "root";
        String password = "password";
        try {
            // Get a connection to DB
            Class.forName(className);
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute SQL query
            String query = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(query);
            // Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nickname") + " " +
                        resultSet.getString("country") + " " +
                        resultSet.getInt("age") + " " +
                        resultSet.getString("gender")
                );
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
