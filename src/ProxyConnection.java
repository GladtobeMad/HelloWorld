
import java.io.IOException;
import java.net.*;
import java.util.Properties;

/**
 * Created by Vlad on 6/15/17.
 */
public class ProxyConnection {

    HttpURLConnection conn;

    public ProxyConnection(String link, String proxy, String port) {

        try {
            URL url = new URL(link);
            Properties properties = System.getProperties();
            properties.setProperty("http.proxyHost", proxy);
            properties.setProperty("http.proxyPort", port);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HttpURLConnection getConnection() {
        return conn;
    }



}
