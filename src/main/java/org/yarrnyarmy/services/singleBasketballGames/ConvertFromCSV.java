package org.yarrnyarmy.services.singleBasketballGames;

import com.opencsv.bean.CsvToBeanBuilder;
import org.yarrnyarmy.model.SingleBasketballGames.AllSingleBasketballPlayers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ConvertFromCSV {


    public List<AllSingleBasketballPlayers> getPlayersFromCSV() {
        List<AllSingleBasketballPlayers> player = null;
        try {
            FileReader file = new FileReader("C:\\Users\\Yarnell\\Desktop\\DKSalaries_3.csv");
            player = new CsvToBeanBuilder<AllSingleBasketballPlayers>(file)
                    .withType(AllSingleBasketballPlayers.class)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            e.getCause();
        }
        return player;
    }

}
