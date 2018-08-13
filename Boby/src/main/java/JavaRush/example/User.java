package JavaRush.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class User {
    private static int countId = 0;
    private static Map <Integer, User> allUsers = new HashMap <>();
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {

            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put( id, this );
            }
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

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex) {
        return getAllUsers( sex ).size();
    }

    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user : allUsers.values()) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User user : getAllUsers( sex )) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers( sex ) / getHowManyUsers( sex );
    }

    public static void main(String[] args) {
        System.out.println( "Все пользователи:" );
        User.getAllUsers().forEach( System.out::println );
        System.out.println( "Все пользователи: MALE" );
        User.getAllUsers( Sex.Male ).forEach( System.out::println );
        System.out.println( "Все пользователи: FEMALE" );
        User.getAllUsers( Sex.Female ).forEach( System.out::println );
        System.out.println( "================================================" );
        System.out.println( "       всех пользователей: " + User.getHowManyUsers() );
        System.out.println( "  всех пользователей MALE: " + User.getHowManyUsers( Sex.Male ) );
        System.out.println( "всех пользователей FEMALE: " + User.getHowManyUsers( Sex.Female ) );
        System.out.println( "================================================" );
        System.out.println( "       общий возраст всех пользователей: " + User.getAllAgeUsers() );
        System.out.println( "  общий возраст всех пользователей MALE: " + User.getAllAgeUsers( Sex.Male ) );
        System.out.println( "общий возраст всех пользователей FEMALE: " + User.getAllAgeUsers( Sex.Female ) );
        System.out.println( "================================================" );
        System.out.println( "       средний возраст всех пользователей: " + User.getAverageAgeOfAllUsers() );
        System.out.println( "  средний возраст всех пользователей MALE: " + User.getAverageAgeOfAllUsers( Sex.Male ) );
        System.out.println( "средний возраст всех пользователей FEMALE: " + User.getAverageAgeOfAllUsers( Sex.Female ) );
        System.out.println( "================================================" );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
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

    public enum Sex {
        Male, Female
    }
}