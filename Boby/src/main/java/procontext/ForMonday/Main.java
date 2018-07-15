package procontext.ForMonday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        String query = "https://vk.com/im?peers=140620469&sel=-157826406";

        TStatus ts = new TStatus();

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL( query ).openConnection();
            connection.setDoOutput( true );
            DataOutputStream wr = new DataOutputStream( connection.getOutputStream() );
            Messages mess = new Messages( "ABC", "12345", "Hello http" );
            String json = GSON.toJson( mess );
            wr.writeBytes( json );
            wr.flush();
            wr.close();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println( connection.getResponseCode() );
                ts.insert( "new", connection.getResponseCode(), null );
            } else {
                System.out.println( "fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage() );
                ts.insert( "new", connection.getResponseCode(), "Error" );
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }
}