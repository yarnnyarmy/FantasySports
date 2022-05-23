package org.yarrnyarmy;

import org.yarrnyarmy.services.AllBasketballGameServices;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AllBasketballGameServices af = new AllBasketballGameServices();
        //af.showAllPlayers();
        af.getAllPF();
    }
}
