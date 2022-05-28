package org.yarrnyarmy.model;

import org.yarrnyarmy.model.SingleBasketballGames.SingleBestTeams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySqlConnection {


       private final String username = "root";



       private final String password = "jabbo0101";



       private final String jdbcURL = "jdbc:mysql://localhost:3306/fantasy_sports";


    public Connection sqlConnection(){
        try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection established...");
            return conn;
        }catch(Exception e){
            System.out.println("Connection failed...");
            e.getCause();
            e.printStackTrace();
            return null;
        }
    }
}
