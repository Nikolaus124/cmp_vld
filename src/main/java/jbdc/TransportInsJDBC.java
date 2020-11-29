package jbdc;

import java.sql.*;

public class TransportInsJDBC {
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
        String sql = "INSERT INTO transportins (id, sn, customer, employee,"+
                " ins_type, crd, term, amount, type, fuel, engcap, brand, model, vin)" +
                "VALUES (1, 25475, 1, 1, 'full', '09-05-1988', 1.5, 850.50, 'Sport_car', 'Gasoline',"+
                "4.2, 'BMW', 'F90', 'WAUZZ098K87WNAA')";
        stmt = conn.createStatement();

        int rowsInserted = stmt.executeUpdate(sql);
        stmt.close();
        conn.close();

        if (rowsInserted > 0) {
            System.out.println("A new transportins was inserted successfully!");
        }
    }

    public static void select() throws SQLException {
        Statement stmt = null;
        Connection conn = connectionTo(null);

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM transportins;");
        while (rs.next()) {
            int id = rs.getInt("id");
            int sn = rs.getInt("sn");
            int customer = rs.getInt("customer");
            int employee = rs.getInt("employee");
            String ins_type = rs.getString("ins_type");
            String crd = rs.getString("crd");
            Double term = rs.getDouble("term");
            Double amount = rs.getDouble("amount");
            String type = rs.getString("type");
            String fuel = rs.getString("fuel");
            Double engcap = rs.getDouble("engcap");
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            String vin = rs.getString("vin");



            System.out.println("ID = " + id);
            System.out.println("SN = " + sn);
            System.out.println("Customer = " + customer);
            System.out.println("Employee = " + employee);
            System.out.println("Ins_Type = " + ins_type);
            System.out.println("CRD = " + crd);
            System.out.println("Term = " + term);
            System.out.println("Amount = " + amount);
            System.out.println("Type = " + type);
            System.out.println("Fuel = " + fuel);
            System.out.println("Eng_Cap = " + engcap);
            System.out.println("Brand = " + brand);
            System.out.println("Model = " + model);
            System.out.println("VIN = " + vin);

            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Operation done successfully");
    }

    public static void update() throws SQLException {

        Connection conn = connectionTo(null);

        String sql = "UPDATE transportins SET crd=? WHERE ins_type=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "29-11-2020");
        statement.setString(2, "full");

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing transportins was updated successfully!");
        }
    }

    public static void delete() throws SQLException {

        Connection conn = connectionTo(null);
        String sql = "DELETE FROM transportins WHERE ins_type=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "full");

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A transportins was deleted successfully!");
        }
    }

    public static void main(String[] args) throws SQLException {
        //insert();
        //select();
        //update();
        //delete();
    }
}
