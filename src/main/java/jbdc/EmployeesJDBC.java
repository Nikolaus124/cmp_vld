package jbdc;

import java.sql.*;

public class EmployeesJDBC {

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

    public static void insert() throws SQLException {
        Statement stmt = null;
        Connection conn = connectionTo(null);
        String sql = "INSERT INTO employees (id, firstname, lastname, bd, lic_numb, tel)"+
                "VALUES (1, 'John', 'Gates', '09-05-1988', '1578943574', '+380504123698')";
        stmt = conn.createStatement();

        int rowsInserted = stmt.executeUpdate(sql);
        stmt.close();
        conn.close();

        if (rowsInserted > 0) {
            System.out.println("A new employee was inserted successfully!");
        }
    }

    public static void select() throws SQLException {
        Statement stmt = null;
        Connection conn = connectionTo(null);

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM employees;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  firstname = rs.getString("firstname");
            String  lastname = rs.getString("lastname");
            String  bd = rs.getString("bd");
            int lic_numb  = rs.getInt("lic_numb");
            String  tel = rs.getString("tel");


            System.out.println( "ID = " + id );
            System.out.println( "FirstName = " + firstname);
            System.out.println( "LastName = " + lastname);
            System.out.println( "BD = " + bd );
            System.out.println( "LICENSE = " + lic_numb );
            System.out.println( "tel = " + tel );
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Operation done successfully");
    }

    public static void update() throws SQLException {

        Connection conn = connectionTo(null);

        String sql = "UPDATE employees SET tel=? WHERE lastname=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "+380000000000");
        statement.setString(2, "Gates");

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing employee was updated successfully!");
        }
    }

    public static void delete() throws SQLException {

        Connection conn = connectionTo(null);
        String sql = "DELETE FROM employees WHERE firstname=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "John");

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A employee was deleted successfully!");
        }
    }

    public static void main(String[] args) throws SQLException {
        //insert();
        //select();
        //update();
        //delete();
    }
}
