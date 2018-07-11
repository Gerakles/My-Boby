package procontext.FourExamplesReadingFromAFileUsingJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestThree {
    public static void main(String[] args) throws IOException {
        List <String> list = Files.readAllLines( Paths.get( "res\\file.txt" ) );

        for (String item : list) {
            System.out.println( item );
        }
    }
}
