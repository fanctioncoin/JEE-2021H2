package by.academy.web.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UserDao {

    public void ConfigManager() {
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();
        try {
            props.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = props.getProperty("driver");
        if (driver != null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        String url = props.getProperty("url");
        String username = props.getProperty("user");
        String password = props.getProperty("password");

        try {
            Connection con = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}




