package exercise;

import java.util.Scanner;

public class Quotes {
    private static void Quotes(String word) {
        int ia1 = 0, ia2 = 0, ib1 = 0, ib2 = 0, ic1 = 0, ic2 = 0;
        char a1 = '(', a2 = ')',
                b1 = '{', b2 = '}',
                c1 = '[', c2 = ']';

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

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String word = sc.nextLine();
        Quotes( word );
    }
}