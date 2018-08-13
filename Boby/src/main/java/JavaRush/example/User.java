package JavaRush.example;

import java.util.Map;
import java.util.Objects;

class Sex {
}

public class User {
    private static Map <Integer, User> allUsers;
    private static int countId = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals( name, user.name ) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, age, sex );
    }
}
