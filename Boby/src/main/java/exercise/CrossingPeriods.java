package exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrossingPeriods {
    private static void CrossingPeriods(String s1, String s2, String e1, String e2) {
        SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );

        Date start1 = null;
        Date start2 = null;
        Date end1 = null;
        Date end2 = null;

        if (s1.length() == 0)
            s1 = "00.00.0000";
        if (s2.length() == 0)
            s2 = "00.00.0000";
        if (e1.length() == 0)
            e1 = "31.12.9999";
        if (e2.length() == 0)
            e2 = "31.12.9999";

        try {
            start1 = format.parse( s1 );
            start2 = format.parse( s2 );
            end1 = format.parse( e1 );
            end2 = format.parse( e2 );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (start1.after( start2 ) && start2.before( end1 )) {
            System.out.println( start1 );
        }
        if (start2.after( start1 ) && start1.before( end2 )) {
            System.out.println( start2 );
        }
        if (end1.after( start2 ) && end1.before( end2 )) {
            System.out.println( end1 );
        }
        if (end2.after( start1 ) && end2.before( end1 )) {
            System.out.println( end2 );
        }
    }

    public static void main(String[] args) {
        CrossingPeriods( "11.11.1111", "11.11.2222", "11.11.3333", "11.11.4444" );
    }
}