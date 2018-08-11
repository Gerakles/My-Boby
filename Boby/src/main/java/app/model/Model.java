package app.model;

import app.entities.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<Users> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList <>(  );
    }

    public void add(Users user) {
        model.add( user );
    }

    public List<String> list() {
        return model.stream().map(Users::getName).collect( Collectors.toList());
    }
}
