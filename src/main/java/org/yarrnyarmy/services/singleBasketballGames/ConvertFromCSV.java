package org.yarrnyarmy.services.singleBasketballGames;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.yarrnyarmy.model.SingleBasketballGames.Players;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConvertFromCSV {


    public void getPlayersFromCSV(){
        try{
            FileReader file = new FileReader("C:\\Users\\yarnn\\OneDrive\\Desktop\\DKSalaries.csv");
            List<Players> player = new CsvToBeanBuilder<Players>(file)
                    .withType(Players.class)
                    .build()
                    .parse();

            for(Players people : player){
                System.out.println(people.getName() + " " + people.getAveragePoints());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            e.getCause();
        }



//        {
//            try {
//                CSVReader csvReader = new CSVReader(file);
//                String[] nextRecord;
//
//                while((nextRecord = csvReader.readNext()) != null){
//                    for (String cell : nextRecord){
//                        System.out.println(cell + "\t");
//                    }
//                    System.out.println();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } catch (CsvValidationException e) {
//                throw new RuntimeException(e);
//            }
//        }


    }

}
