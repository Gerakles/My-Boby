package JavaRush.example;

import java.util.*;

class Sex {
}

public class User {
    private static Map <Integer, User> allUsers;
    private static int countId = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public User(String name, int age, Sex sex) {
        if (allUsers == null) {
            allUsers = new HashMap <>();
        }
        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put( id, this );
        }
    }

    public static List <User> getAllUsers() {
        return new ArrayList <>( allUsers.values() );
    }

    public static List <User> getAllUsers(Sex sex) {
        List <User> listAllUsers = new ArrayList <>();
        for (User user : allUsers.values()) {
            if (user.sex == sex) {
                listAllUsers.add( user );
            }
        }
        return listAllUsers;
    }

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

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals( this ) && user.hashCode() == this.hashCode())
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
    

}