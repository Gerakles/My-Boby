package JavaRush.example.phone;

public class VideoPhone extends AbstractPhone {
    public VideoPhone(int year) {
        super( year );
    }

    @Override
    public void call(int outputnumber) {
        System.out.println( "Connect the video chanel to the subscriber " + outputnumber );
    }

    @Override
    public void ring(int inputnumber) {
        System.out.println( "You have an incoming video call..." + inputnumber );
    }
}