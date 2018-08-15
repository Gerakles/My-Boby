package JavaRush.example.phone;

public class CellPhone extends WirelessPhone {
    public CellPhone(int year, int hour) {
        super( year, hour );
    }

    @Override
    public void call(int outputnumber) {
        System.out.println( "call number " + outputnumber );
    }

    @Override
    public void ring(int inputnumber) {
        System.out.println( "the subscriber is calling you" + inputnumber );
    }
}