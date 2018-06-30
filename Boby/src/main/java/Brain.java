import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class Brain { //7.87 kb
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
    final ImageIcon imageIcon = new ImageIcon("3^7.png");

    private Brain() {
        Color yellow = new Color( 212, 172, 13 );
        Color gray1 = new Color( 100, 100, 125 );

        frame = new JFrame( "Relax Game" );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( 350, 300 );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        frame.setLayout( new BorderLayout() );

        restart = new JButton( "" );
        newGame = new JButton( "" );
        restart.setBorderPainted( false );
        restart.setFocusPainted( false );
        restart.setBackground( gray1 );
        newGame.setBorderPainted( false );
        newGame.setFocusPainted( false );
        newGame.setBackground( gray1 );
        restart.setIcon( new ImageIcon( "n.png" ) );
        newGame.setIcon( new ImageIcon( "s.png" ) );
        newGame.addActionListener( e -> {
            playerName = JOptionPane.showInputDialog( "Write your NickName" );
            output.setText( "Player " + playerName + "\nLevel 1. Write number 1 " );
            setVisionItems( true );
        } );

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
        private static final String HOST = "jdbc:mysql://localhost:3306" +
                "/mydbtest?useSSL=false&serverTimezone=UTC";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        private static final String INSERT_NEW = "INSERT INTO brain VALUES(?,?,?)";
        private static final String GET_ALL = "SELECT * FROM brain";
        private static final String MAX = "SELECT * FROM brain ORDER BY ID DESC LIMIT 1";
//        private static final String DELETE = "DELETE FROM brain WHERE id=2";

        PreparedStatement preparedStatement = null;

        public static void main(String[] args) {
            DB app = new DB();
            app.sellectAll();
            //app.max();
        }

        private Connection connection() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection( HOST, USERNAME, PASSWORD );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        public void insert(String name, int score) {
            try {
                Connection connection = this.connection();
                Statement statement = connection.createStatement();
                preparedStatement = connection.prepareStatement( MAX );
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt( "id" );
                    preparedStatement = connection.prepareStatement( INSERT_NEW );
                    preparedStatement.setInt( 1, ++id );
                    preparedStatement.setString( 2, name );
                    preparedStatement.setInt( 3, score );
                    preparedStatement.executeUpdate();
                }

                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void sellectAll() {
            try {
                Connection connection = this.connection();
                Statement statement = connection.createStatement();
                preparedStatement = connection.prepareStatement( GET_ALL );
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt( "id" );
                    String name = resultSet.getString( "name" );
                    int score = resultSet.getInt( "score" );

                    System.out.println( "id - " + id + ", name '" + name + "', score - " + score );

                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void max() {
            try {
                Connection connection = this.connection();
                Statement statement = connection.createStatement();
                preparedStatement = connection.prepareStatement( MAX );
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt( "id" );
                    System.out.println( "id - " + id );
                }
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private class Nums implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applause = new Audio( "applause.wav", 1 );
            gameOver = new Audio( "Game_over.wav", 1 );
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
