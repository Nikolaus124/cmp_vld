package jbdc;

import java.sql.*;

public class CustomersJDBC {
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
        String sql = "INSERT INTO customers (id, firstname, lastname, bd, id_code, tel, id_card)" +
                "VALUES (1, 'John', 'Gates', '09-05-1988', 1578943574, '+380504123698', 74563254)";
        stmt = conn.createStatement();

        int rowsInserted = stmt.executeUpdate(sql);
        stmt.close();
        conn.close();

        if (rowsInserted > 0) {
            System.out.println("A new customer was inserted successfully!");
        }
    }

    public static void select() throws SQLException {
        Statement stmt = null;
        Connection conn = connectionTo(null);

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM customers;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String bd = rs.getString("bd");
            int id_code = rs.getInt("id_code");
            String tel = rs.getString("tel");
            int id_card = rs.getInt("id_card");


            System.out.println("ID = " + id);
            System.out.println("FirstName = " + firstname);
            System.out.println("LastName = " + lastname);
            System.out.println("BD = " + bd);
            System.out.println("id_code = " + id_code);
            System.out.println("tel = " + tel);
            System.out.println("id_card = " + id_card);
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Operation done successfully");
    }

    public static void update() throws SQLException {

        Connection conn = connectionTo(null);

        String sql = "UPDATE customers SET tel=? WHERE lastname=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "+380000000000");
        statement.setString(2, "Gates");

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing customer was updated successfully!");
        }
    }

    public static void delete() throws SQLException {

        Connection conn = connectionTo(null);
        String sql = "DELETE FROM customers WHERE firstname=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "John");

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A customer was deleted successfully!");
        }
    }

    public static void main(String[] args) throws SQLException {
        //insert();
        //select();
        //update();
        //delete();
    }
}

