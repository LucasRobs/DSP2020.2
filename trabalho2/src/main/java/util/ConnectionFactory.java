package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/DSPersist2021",
                    "postgres","qwe123");
            System.out.println("Conectado");
            return conn;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
