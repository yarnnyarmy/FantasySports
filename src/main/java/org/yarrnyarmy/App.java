package org.yarrnyarmy;

import org.yarrnyarmy.calculations.SingleBasketballCalculations;
import org.yarrnyarmy.services.singleBasketballGames.ConvertFromCSV;

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

        SingleBasketballCalculations sc = new SingleBasketballCalculations();
        sc.getBestTeams();
    }
}
