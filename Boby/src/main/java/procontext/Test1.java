package procontext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        Person person = new Person("Bob", -443, Arrays.asList("Odessa", "Bucovel", "Hmelinitsck"));
        String json = GSON.toJson( person );
        System.out.println(json);
    }
}

class Person {
    private String name;
    private Integer age;
    @SerializedName( "goe" )
    private List<String> geoHistory;

   Person(String name, Integer age, List <String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }
}
