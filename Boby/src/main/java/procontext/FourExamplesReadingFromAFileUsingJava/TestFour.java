package procontext.FourExamplesReadingFromAFileUsingJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFour {
    public static void main(String[] args) throws IOException {
        Files.lines( Paths.get( "res\\file.txt" ) ).forEach( System.out::println );
    }
}
