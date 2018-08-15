package JavaRush.example.phone;

public class SmartPhone extends CellPhone {
    private String operationSystem;

    public SmartPhone(int year, int hour, String operationSystem) {
        super( year, hour );
        this.operationSystem = operationSystem;
    }

    public void install(String program) {
        System.out.println( "Install " + program + " for " + operationSystem );
    }
}