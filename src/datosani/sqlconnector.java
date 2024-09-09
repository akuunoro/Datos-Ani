
package datosani;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnector {
    
    private static sqlconnector instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3309/datos-ani?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "noro";
    private static final String PASSWORD = "TAKTEKA*_19";

    private sqlconnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(sqlconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static sqlconnector getInstance() {
        if (instance == null) {
            instance = new sqlconnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database Connection Closed");
            } catch (SQLException ex) {
                Logger.getLogger(sqlconnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}

    


