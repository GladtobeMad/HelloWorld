import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by Vlad on 6/14/17.
 */
public class Main {

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.say();


        MySQLConnection mySQLConnection
                = new MySQLConnection("jdbc:mysql://mysql-server:3306/helloworld_database","javahelloworld","secret_password");
        Statement st = mySQLConnection.getStatement();
        try {

            PreparedStatement statement = mySQLConnection.getConnection().prepareStatement("INSERT INTO test VALUES (?,?)");
            statement.setString(1, UUID.randomUUID().toString());
            statement.setInt(2, (int) (Math.random()*40) + 10);

            statement.executeUpdate();

            ResultSet rs = st.executeQuery("SELECT * FROM test;");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t" + rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySQLConnection.close();
        }

    }

}
