package JavaRush.example;

import java.util.Map;

class Sex{}

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static Map<Integer, User> allUsers;
    private static int countId = 0;
}
