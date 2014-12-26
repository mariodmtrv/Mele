package org.mele.backend.dataaccess;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class DBConnection {
    private static Connection connection;


    private DBConnection() {
        // can only get the connection
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    public static void destroy() {
        connection = null;
    }

    private static Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Config config = new Config();
        Properties properties = config.getProperties();
        String url = "jdbc:postgresql://" + properties.getProperty("databaseUrl") + File.separator + properties.getProperty("databaseName");
        Properties props = new Properties();
        props.setProperty("user", properties.getProperty("databaseUser"));
        props.setProperty("password", properties.getProperty("databasePassword"));
        try {
            Connection connection = DriverManager.getConnection(url, props);

            return connection;
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
