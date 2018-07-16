package procontext.ForMonday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
}
