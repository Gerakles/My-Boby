package exercise;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrossingPeriods {
    public static void main(String[] args) {
        String sdate1 = "01.03.2016";
        String sdate2 = "01.02.2016";
        String fdate1 = "01.05.2016";
        String fdate2 = "01.08.2016";

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date startOne = null;
        Date startTwo = null;
        Date finalOne = null;
        Date finalTwo = null;

        try {
            startOne = format.parse(sdate1);
            startTwo = format.parse(sdate2);
            finalOne = format.parse(fdate1);
            finalTwo = format.parse(fdate2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (startOne.before( finalTwo )) {
            if (finalOne.after( startTwo )) {
                System.out.println(true);
            }
        }
    }
}
