package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "dbs1";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;
    private Database() { }
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    public static void createConnection(){
        try {
        	
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbs1","sql");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void commit(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void rollback(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}