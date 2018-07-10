package demo;

import java.sql.*;

public class MainBrain {
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
        MainBrain app = new MainBrain();
        app.sellectAll();
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
            preparedStatement = connection.prepareStatement( INSERT_NEW );
            preparedStatement.setInt( 1,1 );
            preparedStatement.setString( 2, name );
            preparedStatement.setInt( 3, score );
            preparedStatement.executeUpdate();
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sellectAll() {
        try {
            Connection connection = this.connection();
            Statement statement = connection.createStatement();
            preparedStatement = connection.prepareStatement( MAX );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt( "id" );
//                String name = resultSet.getString( "name" );
//                int score = resultSet.getInt( "score" );

                System.out.println( "id - " + id);// + ", name '" + name + "', score - " + score );

            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
