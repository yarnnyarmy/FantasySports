package org.yarrnyarmy;

import org.yarrnyarmy.services.UserSelectGame;
import org.yarrnyarmy.services.singleBasketballGames.AddInformationToClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserSelectGame us = new UserSelectGame();
        us.selectGamePlayer();

        //AddInformationToClass it = new AddInformationToClass();
        //it.addPlayersThroughLoop();

        //WebScrapeNVAReference nv = new WebScrapeNVAReference();
        //nv.addPlayersThroughLoop();
    }
}
