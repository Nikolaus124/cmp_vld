package jbdc;

import java.sql.*;

public class LifeInsJDBC {
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
        String sql = "INSERT INTO lifeins (id, sn, customer, employee, ins_type, crd, term, amount, decl)" +
                "VALUES (1, 25475, 1, 1, 'full', '09-05-1988', 1.5, 850.50, 74563254)";
        stmt = conn.createStatement();

        int rowsInserted = stmt.executeUpdate(sql);
        stmt.close();
        conn.close();

        if (rowsInserted > 0) {
            System.out.println("A new lifeins was inserted successfully!");
        }
    }

    public static void select() throws SQLException {
        Statement stmt = null;
        Connection conn = connectionTo(null);

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM lifeins;");
        while (rs.next()) {
            int id = rs.getInt("id");
            int sn = rs.getInt("sn");
            int customer = rs.getInt("customer");
            int employee = rs.getInt("employee");
            String ins_type = rs.getString("ins_type");
            String crd = rs.getString("crd");
            Double term = rs.getDouble("term");
            Double amount = rs.getDouble("amount");
            int decl = rs.getInt("decl");


            System.out.println("ID = " + id);
            System.out.println("SN = " + sn);
            System.out.println("Customer = " + customer);
            System.out.println("Employee = " + employee);
            System.out.println("Ins_Type = " + ins_type);
            System.out.println("CRD = " + crd);
            System.out.println("Term = " + term);
            System.out.println("Amount = " + amount);
            System.out.println("Decl = " + decl);
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Operation done successfully");
    }

    public static void update() throws SQLException {

        Connection conn = connectionTo(null);

        String sql = "UPDATE lifeins SET crd=? WHERE ins_type=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "29-11-2020");
        statement.setString(2, "full");

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing lifeins was updated successfully!");
        }
    }

    public static void delete() throws SQLException {

        Connection conn = connectionTo(null);
        String sql = "DELETE FROM lifeins WHERE ins_type=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "full");

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A lifeins was deleted successfully!");
        }
    }

    public static void main(String[] args) throws SQLException {
        //insert();
        //select();
        //update();
        //delete();
    }
}
