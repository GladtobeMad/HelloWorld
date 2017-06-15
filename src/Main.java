import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

/**
 * Created by Vlad on 6/14/17.
 */
public class Main {

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.say();

        ProxyConnection proxyConnection = new ProxyConnection("http://verbling.com", "proxy.domain.com", 8080, "user", "pass");
        URLConnection conn = proxyConnection.getConnection();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
