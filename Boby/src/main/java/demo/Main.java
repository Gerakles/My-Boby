package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";



    public static void main(String[] args) throws SQLException {
        //Connection to database; Соединение с базой данных
        Connection connection;

        connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        Statement statement = connection.createStatement();
        //add
        //statement.execute( "INSERT INTO animal(anim_name,anim_desc) VALUES ('name','desc');" );
        //update
        //statement.executeUpdate( "UPDATE animal SET anim_name='New Name' WHERE id =1;" );
        //select
        //statement.executeQuery( "SELECT * FROM animal" );
        //add pack
        //statement.addBatch( "INSERT INTO animal(anim_name,anim_desc) VALUES ('Batch1','desc');" );
        //statement.addBatch( "INSERT INTO animal(anim_name,anim_desc) VALUES ('Batch2','desc');" );
        //statement.addBatch( "INSERT INTO animal(anim_name,anim_desc) VALUES ('Batch3','desc');" );
        statement.executeBatch();
        //clear batch
        statement.clearBatch();
        //conection verifity
        statement.getConnection();
        //close
        statement.close();
        if (!connection.isClosed()) {
            System.out.println( "Соединение с БД Установлено!" );
        }
        connection.close();
        if (connection.isClosed()) {
            System.out.println( "Соединение с БД Закрыто!" );
        }
    }
}