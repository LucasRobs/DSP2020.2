import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection getConnection(){
        try {

            Class.forName("org.postgresql.Driver");
            System.out.println("connect");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/DSPersist2021",
                    "postgres","qwe123");
            conn.setAutoCommit(false);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}