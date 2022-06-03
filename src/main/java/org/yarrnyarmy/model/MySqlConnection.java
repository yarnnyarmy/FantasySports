package org.yarrnyarmy.model;

import org.yarrnyarmy.model.SingleBasketballGames.SingleBestTeams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MySqlConnection {
       private final String username = "root";
       private final String jdbcURL = "jdbc:mysql://localhost:3306/fantasy_sports";

    // method to connect to mysql database
    public Connection sqlConnection(){
        System.out.println("Retrieving database...");
        try{
            System.out.println("Enter database password");
            Scanner scan = new Scanner(System.in);
                String password = scan.nextLine();
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
