package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil
 {
    private static final String URL = "jdbc:mysql://localhost:3306/GCRUDX";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException
 {
        try 
        {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

