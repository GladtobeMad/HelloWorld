
import java.io.IOException;
import java.net.*;
import java.util.Properties;

/**
 * Created by Vlad on 6/15/17.
 */
public class ProxyConnection {

    HttpURLConnection conn;

    public ProxyConnection(String link, String proxyHost, int port, String username, String pass) {

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port));
            conn = (HttpURLConnection) new URL(link).openConnection(proxy);
            conn.addRequestProperty("User-Agent","Mozilla/4.0");
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(username, pass.toCharArray()));
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HttpURLConnection getConnection() {
        return conn;
    }


}
