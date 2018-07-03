public class demo {
    public static void main(String[] args){
        String temp = "HELLO! my Lord";

        for (char i : temp.toCharArray()) {
            System.out.print( String.valueOf( i ) );
            try {
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}