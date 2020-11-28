package jbdc;

import java.sql.*;

public class CreateTables {



    public static void createCustomers() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/insurance",
                            "postgres", "2246");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS customers" +
                    "(id INT NOT NULL PRIMARY KEY, FirstName varchar(30) NOT NULL,"+
                    " LastName varchar(30) NOT NULL, BD varchar(30) NOT NULL,"+
                    " id_code INT NOT NULL, Tel varchar(13) NOT NULL, id_card INT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void createEmp() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/insurance",
                            "postgres", "2246");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS employees" +
                    "(id INT NOT NULL PRIMARY KEY,FirstName varchar(30) NOT NULL,"+
                    "LastName varchar(30) NOT NULL,BD varchar(30) NOT NULL,"+
                    "lic_numb INT NOT NULL,Tel varchar(13) NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }


    public static void createLifeIns() {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/insurance",
                            "postgres", "2246");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS lifeIns" +
                    "(id INT NOT NULL PRIMARY KEY," +
                    "sn INT NOT NULL,"+
                    "customer INTEGER REFERENCES customers NOT NULL,"+
                    "employee INTEGER REFERENCES employees NOT NULL,"+
                    "ins_type varchar(50) NOT NULL,crd varchar(10) NOT NULL,"+
                    "term FLOAT NOT NULL,amount FLOAT NOT NULL, decl INT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }


    public static void createDwellingIns(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/insurance",
                            "postgres", "2246");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS dwellingIns" +
                    "(id INT NOT NULL PRIMARY KEY," +
                    "sn INT NOT NULL,"+
                    "customer INTEGER REFERENCES customers NOT NULL,"+
                    "employee INTEGER REFERENCES employees NOT NULL,"+
                    "ins_type varchar(50) NOT NULL,crd varchar(10) NOT NULL,"+
                    "term FLOAT NOT NULL,amount FLOAT NOT NULL, " +
                    "typedw varchar(30) NOT NULL, square FLOAT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }


    public static void createTransportIns(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/insurance",
                            "postgres", "2246");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS transportIns" +
                    "(id INT NOT NULL PRIMARY KEY," +
                    "sn INT NOT NULL,"+
                    "customer INTEGER REFERENCES customers NOT NULL,"+
                    "employee INTEGER REFERENCES employees NOT NULL,"+
                    "ins_type varchar(50) NOT NULL,crd varchar(10) NOT NULL,"+
                    "term FLOAT NOT NULL,amount FLOAT NOT NULL," +
                    "type varchar(30) NOT NULL,fuel varchar(10) NOT NULL,"+
                    "engcap FLOAT NOT NULL, brand varchar(30) NOT NULL,"+
                    "model varchar(30) NOT NULL, vin varchar(30) NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void main(String[] args) {
        //createCustomers();
        //createEmp();

        //createLifeIns();
        //createDwellingIns();
        createTransportIns();
    }
}
