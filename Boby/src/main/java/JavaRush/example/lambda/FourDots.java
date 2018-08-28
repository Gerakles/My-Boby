package JavaRush.example.lambda;

import java.util.LinkedList;
import java.util.List;

public class FourDots {
    public static void main(String[] args) {
        List<String> strings = new LinkedList <>(  );
        strings.add( "To be" );
        strings.add( " or " );
        strings.add( "not to be" );

        strings.forEach( System.out::print );
    }
}