package org.yarrnyarmy.doa;

import org.yarrnyarmy.calculations.singleBasketball.SingleBasketballCalculations;
import org.yarrnyarmy.model.MySqlConnection;

import java.sql.Connection;

public class SingleGameDatabase {

    SingleBasketballCalculations sc = new SingleBasketballCalculations();
    MySqlConnection sqlConnection = new MySqlConnection();
    public Connection getAllPlayersFromDatabase(){
        Connection connect = sqlConnection.sqlConnection();
        return null;
    }
}
