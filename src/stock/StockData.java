package stock;

// Skeleton version of StockData.java that links to a database.
// NOTE: You should not have to make any changes to the other
// Java GUI classes for this to work, if you complete it correctly.
// Indeed these classes shouldn't even need to be recompiled
import java.sql.*; // DB handling package
import java.io.*;
import org.apache.derby.drda.NetworkServerControl;

public class StockData {

    private static Connection connection;
    private static Statement stmt;

    static {
        // standard code to open a connection and statement to an Access database
        try {
            NetworkServerControl server = new NetworkServerControl();
            server.start(null);
            // Load JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Establish a connection
            String sourceURL = "jdbc:derby://localhost:1527/"
                    + new File("UserDB").getAbsolutePath() + ";";
            connection = DriverManager.getConnection(sourceURL, "use", "use");
            stmt = connection.createStatement();
        } // The following exceptions must be caught
        catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // You could make methods getName, getPrice and getQuantity simpler by using an auxiliary
    // private String method getField(String key, int fieldNo) to return the appropriate field as a String
    public static String getName(String key) {
        
        
        try {
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM stock WHERE id =" + Integer.parseInt(key) );
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getString(2);
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static double getPrice(String key) {
        
        try {
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM stock WHERE id = " + key);
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getDouble(3);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    public static int getQuantity(String key) {
        
        try {
            // Need single quote marks ' around the key field in SQL. This is easy to get wrong!
            // For instance if key was "11" the SELECT statement would be:
            // SELECT * FROM Stock WHERE stockKey = '11'
            ResultSet res = stmt.executeQuery("SELECT * FROM stock WHERE id = " + key);
            if (res.next()) { // there is a result
                // the name field is the second one in the ResultSet
                // Note that with  ResultSet we count the fields starting from 1
                return res.getInt(4);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    // update stock levels
    // extra is +ve if adding stock
    // extra is -ve if selling stock
    public static void update(String key, int extra) {
        
        // SQL UPDATE statement required. For instance if extra is 5 and stockKey is "11" then updateStr is
        // UPDATE Stock SET stockQuantity = stockQuantity + 5 WHERE stockKey = '11'
        String updateStr = "UPDATE stock SET quantity = quantity + " + extra + " WHERE key = '" + key + "'";
        System.out.println(updateStr);
        try {
            stmt.executeUpdate(updateStr);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void purchase(String key, int quantityPurchased) {
        
        // SQL UPDATE statement required. For instance if extra is 5 and stockKey is "11" then updateStr is
        // UPDATE Stock SET stockQuantity = stockQuantity + 5 WHERE stockKey = '11'
        String updateStr = "UPDATE stock SET quantity = quantity + " + -quantityPurchased + " + WHERE key = " + key;
        System.out.println(updateStr);
        try {
            stmt.executeUpdate(updateStr);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // close the database
    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // this shouldn't happen
            System.out.println(e);
        }
    }
}
