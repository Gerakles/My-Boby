package procontext.ForMonday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;

class Brain { // 1.66 kb
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    static void realize(String message) {



        String query = "https://vk.com/im?peers=140620469&sel=-157826406";
        TStatus ts = new TStatus();
        TMessage tm = new TMessage();
        HttpURLConnection connection = null;
        Messages mess = new Messages( "ABC", "12345", message );

        try {
            connection = (HttpURLConnection) new URL( query ).openConnection();
            connection.setDoOutput( true );
            DataOutputStream wr = new DataOutputStream( connection.getOutputStream() );
            String json = GSON.toJson( mess );
            wr.writeBytes( json );
            wr.flush();
            wr.close();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                ts.insert( "new", 1, null );
                tm.insert( Time.valueOf( LocalTime.now() ), message, connection.getResponseCode(), "ok" );
            } else {
                ts.insert( "new", 0, "Error" );
                tm.insert( Time.valueOf( LocalTime.now() ), message, connection.getResponseCode(), "error" );
                System.out.println( connection.getResponseCode() + ", " + connection.getResponseMessage() );
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) connection.disconnect();
        }
    }
}