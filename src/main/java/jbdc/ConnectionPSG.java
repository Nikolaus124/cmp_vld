package jbdc;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPSG {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/insurance";
    static final String USER = "postgres";
    static final String PASS = "2246";

    public static Connection connectionTo(Connection connection) {
        try {
            connection = (Connection) DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return connection;
        }
        return connection;
    }

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        Connection connection = connectionTo(null);


        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
}