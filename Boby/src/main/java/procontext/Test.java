package procontext;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        DataInputStream dis = new DataInputStream( new FileInputStream( "res\\file.txt" ) );
    }
}
