package procontext.ForMonday;

import java.util.Scanner;

public class Main { // 398 b
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String message = sc.nextLine();
            if (message != null) {
                Brain.realize( message );
                System.out.println( "ok" );
            }
        }
    }
}