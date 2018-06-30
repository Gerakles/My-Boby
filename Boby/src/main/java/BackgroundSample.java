import java.awt.*;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BackgroundSample {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Background Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ImageIcon imageIcon = new ImageIcon("3^7.png");
        JTextArea output = new JTextArea() {
            Image image = imageIcon.getImage();
            {
                setOpaque(false);
            }

            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, this);
                super.paint(g);
            }
        };
        output.setBackground( Color.gray );
        JScrollPane scrollPane = new JScrollPane(output);
        Container content = frame.getContentPane();
        content.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(350, 300);
        frame.setVisible(true);
    }
}