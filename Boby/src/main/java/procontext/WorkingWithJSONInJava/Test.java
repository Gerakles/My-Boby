package procontext.WorkingWithJSONInJava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Test {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Person person = new Person( "Bob", -442, Arrays.asList( "Odessa", "Bucovel", "Hmelinitsck" ) );
        String json = GSON.toJson( person );
        System.out.println( json );

        Person person1 = GSON.fromJson( json, Person.class );
        System.out.println( person1.getName() );
        System.out.println( person1.getAge() );
        System.out.println( person1.getGeoHistory() );
    }
}

class Person {
    private String name;
    private Integer age;
    @SerializedName("goe")
    private List <String> geoHistory;

    Person(String name, Integer age, List <String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    List <String> getGeoHistory() {
        return geoHistory;
    }
}