import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vlad on 6/14/17.
 */
public class Main {

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.say();

        Scanner read = new Scanner(System.in);

        while (true) {

            URL website = null;
            String url = read.nextLine();
            try {
                website = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String html = "";

            try {
                String line;
                BufferedReader htmlReader = new BufferedReader(new InputStreamReader(website.openStream()));
                while ((line = htmlReader.readLine()) != null) {
                    html += line;
                    html += "\n";
                }
                htmlReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Pattern pattern = Pattern.compile("<title>(.*)</title>", Pattern.DOTALL);
            Matcher mat = pattern.matcher(html);
            if (mat.find()) {
                String name = mat.group();
                System.out.println("The name of the website is: " + name);
            } else {
                System.out.println("The name of the website was not found.");
            }
            
        }

    }

}
