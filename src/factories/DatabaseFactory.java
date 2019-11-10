package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseFactory {

    public final static String DATABASE = "library";
    public final static String URL = "jdbc:postgresql:" + DATABASE;
    public final static String USER = "postgres";
    public final static String PASS = "root";

    static public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
}
