package procontext.ForMonday;

import java.sql.*;

public class TStatus { // 1.59 kb
    private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO t_status VALUES(?,?,?,?)";
    private static final String MAX = "SELECT * FROM t_status ORDER BY ID DESC LIMIT 1";

    private PreparedStatement preparedStatement = null;

    private Connection connection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection( HOST, USERNAME, PASSWORD );
        return connection;
    }

    public void insert(String New, int Execute, String Error) {
        try {
            Connection connection = this.connection();
            Statement statement = connection.createStatement();
            preparedStatement = connection.prepareStatement( MAX );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt( "id" );
                preparedStatement = connection.prepareStatement( INSERT_NEW );
                preparedStatement.setInt( 1, ++id );
                preparedStatement.setString( 2, New );
                preparedStatement.setInt( 3, Execute );
                preparedStatement.setString( 4, Error );
                preparedStatement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}