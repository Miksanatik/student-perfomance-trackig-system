package by.gsu.asoilab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String className = "com.mysql.cj.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://127.0.0.1:3306/courses_db?serverTimezone=Europe/Minsk";
<<<<<<< HEAD:src/by/gsu/asoilab/DatabaseConnection.java
    private String username = "root";
    private String password = "1234567890";
=======
    private String username = "Alina";
    private String password = "alina12";
>>>>>>> 647398086a359f0a54cb38528a57bd1b0c10cbcc:src/by/gsu/asoilab/database/DatabaseConnection.java

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName(className);
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Problems with the database connection creation: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
