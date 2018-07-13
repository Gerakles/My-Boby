package procontext.ForMonday;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String query = "https://vk.com/im?peers=140620469&sel=-157826406";

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL( query ).openConnection();
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println( "ok" );
            } else
                System.out.println( "fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage() );
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }
}
