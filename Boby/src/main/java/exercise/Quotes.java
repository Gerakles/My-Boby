package exercise;

import java.util.Scanner;

public class Quotes {
    public static int ia1, ia2, ib1, ib2, ic1, ic2;
    private static char a1 = '(', a2 = ')';
    private static char b1 = '{', b2 = '}';
    private static char c1 = '[', c2 = ']';

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String word = sc.nextLine();
        for (char i : word.toCharArray()) {
            if (i == a1)
                ia1++;
            if (i == a2)
                ia2++;
            if (i == b1)
                ib1++;
            if (i == b2)
                ib2++;
            if (i == c1)
                ic1++;
            if (i == c2)
                ic2++;
        }
        if (ia1 == ia2) {
            if (ib1 == ib2) {
                if (ic1 == ic2)
                    System.out.println( "true" );
                else
                    System.out.println( "false" );
            } else
                System.out.println( "false" );
        } else
            System.out.println( "false" );
    }
}

