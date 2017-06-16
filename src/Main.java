import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Vlad on 6/14/17.
 */
public class Main {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.println("Please login into your proxy.");
        System.out.print("Username: ");
        String username = read.nextLine();
        System.out.print("Password: ");
        String password = read.nextLine();

        ProxyConnection proxyConnection = new ProxyConnection("https://verbling.com/sitemap.xml", "185.112.15.152", 2831, username, password);
        HttpURLConnection conn = proxyConnection.getConnection();

        String parsedHTML = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parsedHTML += (line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
