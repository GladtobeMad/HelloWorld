import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vlad on 6/15/17.
 */
public class MySQLConnection {

    Connection conn;
    Statement st;

    public MySQLConnection(String url, String user, String pass) {

        try {
            Class.forName("com.sql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Statement getStatement() {
        return st;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
