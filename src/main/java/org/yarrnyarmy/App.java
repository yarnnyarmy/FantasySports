package org.yarrnyarmy;

import org.yarrnyarmy.calculations.AllGameBasketballCalculations;
import org.yarrnyarmy.services.allBasketballGames.singleBasketballGames.ConvertFromCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //AllBasketballGameServices af = new AllBasketballGameServices();
        //af.getAllSG();
        //af.addAllPlayers();

        //AllGameBasketballCalculations afc = new AllGameBasketballCalculations();
        //afc.getAllBestTeams();

        ConvertFromCSV csv = new ConvertFromCSV();
        csv.getPlayersFromCSV();
    }
}
