package procontext.FourExamplesReadingFromAFileUsingJava;

import java.io.FileInputStream;
import java.util.Scanner;

public class TestTwo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner( new FileInputStream( "res\\file.txt" ) );

        while (scanner.hasNextLine()) {
            System.out.println( scanner.nextLine() );
        }
    }
}
