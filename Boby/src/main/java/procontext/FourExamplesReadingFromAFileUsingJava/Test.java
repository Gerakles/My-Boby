package procontext.FourExamplesReadingFromAFileUsingJava;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream( new FileInputStream( "res\\file.txt" ) );

        byte[] buffer = new byte[512];
        while (dis.available() != 0) {
            int count = dis.read( buffer );

            if (count > 0)
                System.out.println( new String( buffer ) );
        }
    }
}
