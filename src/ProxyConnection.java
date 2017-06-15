
import java.io.IOException;
import java.net.*;
import java.util.Properties;

/**
 * Created by Vlad on 6/15/17.
 */
public class ProxyConnection {

    URLConnection conn;

    public ProxyConnection(String link, String proxyHost, int port, String username, String pass) {

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, port));
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(username, pass.toCharArray()));
                }
            });
            conn = new URL(link).openConnection(proxy);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public URLConnection getConnection() {
        return conn;
    }


}
