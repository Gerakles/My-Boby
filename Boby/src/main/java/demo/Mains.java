package demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mains {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from mydbtest.userss";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery( query );

            while (resultSet.next()) {
                User user = new User(  );
                user.setId( resultSet.getInt( 1 ) );
                user.setUsername(resultSet.getString( 2 ));
                user.setPassword(resultSet.getString( 3 ));

                System.out.println(user);
                //int id = resultSet.getInt( 1 );
                //System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
