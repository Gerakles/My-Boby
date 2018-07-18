package procontext.ForMonday;

import java.sql.*;

public class TMessage { //1.67 kb
    private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO t_message VALUES(?,?,?,?,?)";
    private static final String MAX = "SELECT * FROM t_message ORDER BY ID DESC LIMIT 1";

    private PreparedStatement preparedStatement = null;

    private Connection connection() throws SQLException {
        Connection connection;

        connection = DriverManager.getConnection( HOST, USERNAME, PASSWORD );
        return connection;
    }

    public void insert(Time created, String message, int read, String execute) {
        try {
            Connection connection = this.connection();
            Statement statement = connection.createStatement();
            preparedStatement = connection.prepareStatement( MAX );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt( "id" );
                preparedStatement = connection.prepareStatement( INSERT_NEW );
                preparedStatement.setInt( 1, ++id );
                preparedStatement.setTime( 2, created );
                preparedStatement.setString( 3, message );
                preparedStatement.setInt( 4, read );
                preparedStatement.setString( 5, execute );
                preparedStatement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
