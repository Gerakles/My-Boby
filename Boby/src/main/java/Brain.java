import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class Brain extends Component { //2.71 Kb
    private static int iter = 1;
    private static String playerName;
    private static Audio gameOver;
    private static Audio applause;
    private JTextArea output;
    private JTextField input;
    private JButton newGame;
    private JButton restart;
    private JFrame frame;
    private JPanel buttonsPanel;
    private JPanel mPanel;

    private Brain() {
        Color yellow = new Color( 212, 172, 13 );
        Color gray1 = new Color( 123, 125, 125 );

        frame = new JFrame( "Smart Boby" );
        frame.setSize( 350, 300 );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo( null );
        frame.setLayout( new BorderLayout() );

        newGame = new JButton( "" );
        newGame.setBorderPainted( false );
        newGame.setFocusPainted( false );
        newGame.setBackground( gray1 );
        newGame.setIcon( new ImageIcon( "Boby/src/main/java/get/s.png" ) );
        newGame.addActionListener( e -> {
            playerName = JOptionPane.showInputDialog( "Write your NickName" );
            output.setText( "Player " + playerName + "\nLevel 1. Write number 1 " );
            setVisionItems( true );
        } );

        restart = new JButton( "" );
        restart.setBorderPainted( false );
        restart.setFocusPainted( false );
        restart.setBackground( gray1 );
        restart.setIcon( new ImageIcon( "Boby/src/main/java/get/n.png" ) );

        buttonsPanel = new JPanel( new BorderLayout() );
        buttonsPanel.setLayout( new GridLayout( 1, 2 ) );
        buttonsPanel.add( newGame );
        frame.add( buttonsPanel, BorderLayout.NORTH );

        input = new JTextField( 20 );
        input.setBackground( gray1 );
        input.setForeground( Color.RED );
        frame.add( input, BorderLayout.SOUTH );

        mPanel = new JPanel();
        mPanel.setLayout( new BorderLayout() );

        output = new JTextArea();
        Font font = new Font( "Arial", Font.PLAIN, 15 );
        output.setFont( font );
        output.setBackground( gray1 );
        output.setForeground( yellow );

        mPanel.setBackground( gray1 );
        mPanel.add( output, BorderLayout.CENTER );
        frame.add( mPanel, BorderLayout.CENTER );
    }

    public static void main(String[] args) {
        new Brain().start();
    }

    private void start() {
        setVisionItems( false );
        input.addActionListener( new Nums() );
        restart.addActionListener( new Restarts() );
    }

    private void setVisionItems(boolean pass) {
        input.setVisible( pass );
        output.setVisible( pass );

        if (pass) {
            buttonsPanel.add( restart, BorderLayout.EAST );
        }
    }

    static class DB {
        private static final String url = "jdbc:sqlite:D://lectii/My Boby/db/Boby.db";

        public static void main(String[] args) {
            DB app = new DB();
            //app.createNewTable();
            app.sellectAll();
        }

        private void createNewTable() {
            String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                    + "	name text NOT NULL,\n"
                    + " score integer PRIMARY KEY\n"
                    + ");";
            try (Connection conn = this.connect();
                 Statement statement = conn.createStatement()) {
                // create a new table
                statement.execute( sql );
            } catch (SQLException e) {
                System.out.println( e.getMessage() );
            }
        }

        private Connection connect() {
            // SQLite connection string
            Connection conn = null;
            try {
                conn = DriverManager.getConnection( url );
            } catch (SQLException e) {
                System.out.println( e.getMessage() );
            }
            return conn;
        }

        private void insert(String name, int score) {
            String sql = "INSERT INTO user(name,score) VALUES(?,?)";
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement( sql )) {
                pstmt.setString( 1, name );
                pstmt.setInt( 2, score );
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println( e.getMessage() );
            }
        }

        private void sellectAll() {
            String sql = "SELECT name, score FROM user";
            try (Connection conn = this.connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery( sql )) {
                // loop through the result set
                while (rs.next()) {
                    System.out.println( rs.getString( "name" ) + "\t" +
                            rs.getInt( "score" ) );
                }
            } catch (SQLException e) {
                System.out.println( e.getMessage() );
            }
        }
    }

    private class Nums implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applause = new Audio( "Boby/src/main/java/get/applause.wav", 1 );
            gameOver = new Audio( "Boby/src/main/java/get/Game_over.wav", 1 );
            Random random = new Random();
            int target = random.nextInt( iter ) + 1;
            iter++;

            Integer keyValue = Integer.parseInt( input.getText() );
            String temp = String.format( "Level %s. Write number at 1 to %s ", iter, iter );

            if (keyValue == target) {
                output.append( "........" + keyValue + " - Good! \n" );
                output.append( temp );
                applause.sounds();
                applause.setVolumes();
                input.setText( "" );
            } else {
                output.append( "........" + keyValue + " - Game over! \n" );
                gameOver.sounds();
                gameOver.setVolumes();
                output.append( "Answer : " + target );
                input.setEnabled( false );
                input.setText( "" );
                DB app = new DB();
                app.insert( playerName, iter - 1 );
            }
        }
    }

    private class Restarts implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            output.setText( "Player " + playerName + "\nLevel 1. Write number 1 " );
            input.setEnabled( true );
            iter = 1;
        }
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
}