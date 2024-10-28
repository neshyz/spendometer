package com.neshy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.neshy.utils.stringutils.Console;

public class Mysql {

    private String url;
    private String username;
    private String password;
    private String database;
    private Connection connection;

    public Connection ConnectDatabase(String URL, String database, String username, String password) {

        try {
            
            connection = AttemptConnection(url, database, username, password);

            System.out.println("Connected to the database!");

            return connection;
            
        } catch (SQLException e) {
            Console.printf("MySQL Connection Failed! (message: %s)", e.getMessage());
            return null;
        }
    }

    public Connection AttemptConnection(String URL, String database, String username, String password) throws SQLException {

        this.database = database;
        this.url = parseDbUrl(URL, this.database);
        this.username = username;
        this.password = password;

        return DriverManager.getConnection(this.url, this.username, this.password);

    }

    public boolean DisconnectDatabase(Connection connection) {

        if(!IsValidConnection(connection)) {

            throw new IllegalArgumentException("Connection is not valid!");

        }
        else {

            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                Console.printf("MySQL Disconnection Failed! (message: %s)", e.getMessage());
                return false;
            }

        }
    }

    public boolean IsValidConnection(Connection connection) {
    
        if(connection == null) {
    
            return false;
    
        }
        
        try {
    
            if(!connection.isValid(5)) {
    
                Console.printError("Connection is null!");
                return false;
    
            }
    
        } catch(Exception e) {
            Console.printException(e);
            return false;
        }
    
        return true;
    }

    public String parseDbUrl(String URL, String database) {

        return "jdbc:mysql://" + URL + "/" + database;

    }
}
