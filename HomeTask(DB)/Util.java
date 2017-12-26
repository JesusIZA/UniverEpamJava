package homeWork.hw8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abstract class connector to DB
 *
 * @author Jesus Raichuk
 */
public abstract class Util {
    /**
     * DB driver
     */
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * DB URL
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/air";
    /**
     * DB user name
     */
    private static final String DB_USERNAME = "root";
    /**
     * DB password
     */
    private static final String DB_PASSWORD = "root";

    /**
     * Get connection to DB
     * @return connection
     */
    public Connection getConnection(){
        Connection connection = null;
        try {
            //Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection ERROR!");
        }

        return connection;
    }

    /**
     * Stop connection to DB
     */
    public abstract void stopConnection();

}