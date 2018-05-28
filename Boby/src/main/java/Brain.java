import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Brain extends Component { //2.71 Kb
    private static Audio hello;

    private Brain() {
        JFrame f = new JFrame( "Smart Boby" );
        JButton but1 = new JButton( "" );
        JPanel butPan = new JPanel( new BorderLayout() );

        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        try {
            f.setContentPane( new JLabel( new ImageIcon( ImageIO.read( new File(
                    "D:/lectii/My Boby/Boby/src/main/java/get/Boby2.jpg" ) ) ) ) );
        } catch (IOException e) {
            System.out.println( "does not exist" );
        }

        f.setResizable( false );
        f.pack();
        f.setVisible( true );

        but1.setBorderPainted( false );
        but1.setFocusPainted( false );
        but1.setBackground( Color.CYAN );

        butPan.setLayout( new GridLayout( 1, 1 ) );
        butPan.add( but1 );
        f.add( butPan, BorderLayout.CENTER );

        but1.addActionListener( new Actio() );
    }

    public static void main(String[] args) {
        new Brain();
    }

    private class Audio {
        private String track;
        private Clip clip = null;
        private FloatControl volumes = null;
        private double wt;

        Audio(String track, double wt) {
            this.track = track;
            this.wt = wt;
        }

        private void sounds() {
            File file = new File( this.track );
            AudioInputStream ais = null;
            try {
                ais = AudioSystem.getAudioInputStream( file );
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            try {
                clip = AudioSystem.getClip();
                clip.open( ais );
                volumes = (FloatControl) clip.getControl( FloatControl.Type.MASTER_GAIN );

                clip.setFramePosition( 0 );
                clip.start();
            } catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }

        void setVolumes() {
            if (wt < 0) wt = 0;
            if (wt > 1) wt = 1;
            float min = volumes.getMinimum();
            float max = volumes.getMaximum();
            volumes.setValue( (max - min) * (float) wt + min );
        }
    }

    private class Actio implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hello = new Audio( "Boby/src/main/java/get/hello.wav", 1 );
            hello.sounds();
            hello.setVolumes();
        }
    }
}