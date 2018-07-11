package procontext.SerializationOfObjectsInJava;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test {
    private static final String FILE_NAME = "res\\file.dat";

    public static void main(String[] args) {
        Map <Integer, String> map = new HashMap <>();
        map.put( 1, "One" );
        map.put( 2, "Two" );
        map.put( 3, "Three" );

        try (ObjectOutput output = new ObjectOutputStream( new FileOutputStream( FILE_NAME ) );
             ObjectInput input = new ObjectInputStream( new FileInputStream( FILE_NAME ) )) {

            output.writeObject( map );
            map = (Map <Integer, String>) input.readObject();
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
        map.forEach( (key, value) -> System.out.println( key + "-> " + value ) );
    }
}