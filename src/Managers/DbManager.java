package Managers;

import java.sql.*;

/**
 * Created by Johan on 04/03/2016.
 */
public final class DbManager {

    public static int ExecuteUpdate(String query) throws SQLException {
        return DbManager.DbStatement().executeUpdate(query);
    }

    public static ResultSet ExecuteQuery(String query) throws SQLException {
        return DbManager.DbStatement().executeQuery(query);
    }

    public static Statement DbStatement() throws SQLException {
        Connection connection = DbConnection();
       return connection.createStatement();
    }

    public static Connection DbConnection() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:easylift.sqlite");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            //System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }
}
