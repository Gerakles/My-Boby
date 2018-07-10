package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.Statement;
import java.util.Calendar;

public class Main3 {
    private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id=2";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection( HOST, USERNAME, PASSWORD );
            Statement statement = connection.createStatement();

            //preparedStatement = connection.prepareStatement( DELETE );
            //preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement( GET_ALL );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt( "id" );
                String title = resultSet.getString( "title" );
                String desc = resultSet.getString( "description" );
                float rating = resultSet.getFloat( "rating" );
                boolean published = resultSet.getBoolean( "published" );
                Date date = resultSet.getDate( "created" );
                byte[] icon = resultSet.getBytes( "icon" );

                System.out.println("id - "+id+", title '"+title+"', description - "+desc+
                        ", rating - "+rating+", published - "+published+", created - "+date+", icon - "+icon.length);
            }
            preparedStatement = connection.prepareStatement( INSERT_NEW );

            preparedStatement.setInt( 1,2 );
            preparedStatement.setString( 2,"Insert title" );
            preparedStatement.setString( 3,"Insert desc" );
            preparedStatement.setFloat( 4, 0.2f );
            preparedStatement.setBoolean( 5, true );
            preparedStatement.setDate( 6,new Date( Calendar.getInstance().getTimeInMillis() ));
            preparedStatement.setBlob( 7, new FileInputStream( "n.png" ) );

            preparedStatement.execute();
            statement.close();
            if (!connection.isClosed()) {
                System.out.println( "Соединение с БД Установлено!" );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
