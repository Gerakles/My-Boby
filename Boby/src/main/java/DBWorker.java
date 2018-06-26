import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    public DBWorker() throws SQLException {
        Connection connection = DriverManager.getConnection( HOST, USERNAME, PASSWORD );
    }
}
