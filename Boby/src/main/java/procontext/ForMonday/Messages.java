package procontext.ForMonday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Messages {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private String login;
    private String pass;
    private String message;

    public Messages(String login, String pass, String message) {
        this.login = login;
        this.pass = pass;
        this.message = message;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String message = sc.nextLine();
        Messages mess = new Messages( "ABC", "12345", message );
        String json = GSON.toJson( mess );
        System.out.println( json );
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getMessage() {
        return message;
    }
}
