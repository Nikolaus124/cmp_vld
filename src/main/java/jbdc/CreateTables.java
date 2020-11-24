package jbdc;

import java.sql.*;

public class CreateTables {

    public Connection connect = ConnectionPSG.connectionTo(null);
    public static ResultSet rs = null;
    public static Statement st = null;

    public static void createCustomers() {
        try {

            String qs = "CREATE TABLE IF NOT EXISTS customers" +
                    "(id INT NOT NULL PRIMARY KEY, FirstName varchar(30) NOT NULL,"+
                    " LastName varchar(30) NOT NULL, BD varchar(30) NOT NULL,"+
                    " id_code INT NOT NULL, Tel varchar(13) NOT NULL, id_card INT NOT NULL)";
            String qs1 = "SELECT * FROM customers";
            rs = st.executeQuery(qs1);
            System.out.println("connect");
        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            System.exit(1);
        }
    }

    public static void createEmp() {
        try {

            String qs = "CREATE TABLE IF NOT EXISTS employees" +
                    "(id INT NOT NULL PRIMARY KEY,FirstName varchar(30) NOT NULL,"+
                    "LastName varchar(30) NOT NULL,BD varchar(30) NOT NULL,"+
                    "lic_numb INT NOT NULL,Tel varchar(13) NOT NULL)";
            String qs1 = "SELECT * FROM customers";
            rs = st.executeQuery(qs);
            System.out.println("connect");
        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            System.exit(1);
        }
    }

    public static void createLifeIns() {
        try {

            String qs = "CREATE TABLE IF NOT EXISTS life_ins" +
                    "(id INT NOT NULL PRIMARY KEY," +
                    "FOREIGN KEY () REFERENCES items(),"+
                    "LastName varchar(30) NOT NULL,BD varchar(30) NOT NULL,"+
                    "lic_numb INT NOT NULL,Tel varchar(13) NOT NULL)";
            String qs1 = "SELECT * FROM customers";
            rs = st.executeQuery(qs);
            System.out.println("connect");
        } catch (SQLException sqle) {
            System.out.println("Could not connect");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        createCustomers();
        //createEmp();
    }
}
