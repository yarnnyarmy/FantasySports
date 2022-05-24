package org.yarrnyarmy.services.allBasketballGames.singleBasketballGames;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ConvertFromCSV {


    public void getPlayersFromCSV(){
        FileReader file;

        {
            try {
                file = new FileReader("C:\\Users\\Yarnell\\Desktop\\DKSalaries.csv");
                CSVReader csvReader = new CSVReader(file);
                String[] nextRecord;

                while((nextRecord = csvReader.readNext()) != null){
                    for (String cell : nextRecord){
                        System.out.println(cell + "\t");
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
