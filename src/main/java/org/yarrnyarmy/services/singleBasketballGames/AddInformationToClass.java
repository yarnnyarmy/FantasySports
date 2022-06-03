package org.yarrnyarmy.services.singleBasketballGames;

import com.opencsv.bean.CsvToBeanBuilder;
import org.yarrnyarmy.model.SingleBasketballGames.AllSingleBasketballPlayers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import javax.swing.text.html.HTML;

public class AddInformationToClass {
    List<AllSingleBasketballPlayers> players;
    // method to select single game players from an CSV file
    public List<AllSingleBasketballPlayers> getPlayersFromCSV() {
        // Create a list from single game model
        if (this.players == null) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the file you wish to parse");
            String csvParse = scan.nextLine();
            try {
                // using opencsv to bind the model of SingleBasketballPlayers to the CSV columns
                //using scanner to ask user to enter the files location

                //using file reader to read the file location

                FileReader file = new FileReader(csvParse);
                System.out.println("Reading File.");
                // the AllSingleBasketballPlayers model will bind with csv
                System.out.println("Adding players to a list");
                List<AllSingleBasketballPlayers> player = new CsvToBeanBuilder<AllSingleBasketballPlayers>(file)
                        .withType(AllSingleBasketballPlayers.class)
                        .build()
                        .parse();
                this.players = player;
                return player;

            } catch (FileNotFoundException e) {
                System.out.println("Unable to retrieve csv");
                e.printStackTrace();
                e.getCause();
                return null;
            }

        }
        else {
            return this.players;
        }
    }

    public void addPlayerStats(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter team abbreviation");
        String teamAbb = scan.nextLine();
        //Instantiate the client
        try (WebClient client = new WebClient()) {
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            //Set up the URL with the search term and send the request
            String searchUrl = "https://www.basketball-reference.com/teams/" + teamAbb + "/2022.html#all_per_minute-playoffs_per_minute";
            try {
                System.out.println("Retrieving page");
                HtmlPage page = client.getPage(searchUrl);
                final HtmlTable table = page.getHtmlElementById("playoffs_per_game");
                for (final HtmlTableRow row : table.getRows()) {
                    System.out.println("Found row");
                    for (final HtmlTableCell cell : row.getCells()) {
                        System.out.println("    Found cell: " + cell.asNormalizedText());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<AllSingleBasketballPlayers> addAllPlayers() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        List<AllSingleBasketballPlayers> asb = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first team's abbreviation");
        String teamAbb1 = scan.nextLine();
        System.out.println("Enter second team's abbreviation");
        String teamAbb2 = scan.nextLine();
        //Instantiate the client
        try (WebClient client = new WebClient()) {
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            //Set up the URL with the search term and send the request
            String searchUrl1 = "https://www.basketball-reference.com/teams/" + teamAbb1 + "/2022.html#all_per_minute-playoffs_per_minute";
            String searchUrl2 = "https://www.basketball-reference.com/teams/" + teamAbb2 + "/2022.html#all_per_minute-playoffs_per_minute";

            System.out.println("Retrieving page");
            try {
                System.out.println("Adding first team");
                HtmlPage page = client.getPage(searchUrl1);
                final HtmlTable table = page.getHtmlElementById("playoffs_per_game");
                List<HtmlTableRow> row1 = null;
                for (final HtmlTableBody body : table.getBodies()){
                     row1 = body.getRows();
                }
                for (int i = 0; i < row1.size(); i++){
                    AllSingleBasketballPlayers bs1 = new AllSingleBasketballPlayers();
                    String name = String.valueOf(row1.get(i).getCell(1).asNormalizedText());
                    bs1.setName(name);
                    int gamesPlayed = Integer.parseInt( String.valueOf(row1.get(i).getCell(3).asNormalizedText()));
                    bs1.setGamesPlayed(gamesPlayed);
                    int gamesStarted= Integer.parseInt( String.valueOf(row1.get(i).getCell(4).asNormalizedText()));
                    bs1.setGamesStarted(gamesStarted);
                    double minutesPlayed = nf.parse(String.valueOf(row1.get(i).getCell(5).asNormalizedText())).doubleValue();
                    bs1.setMinPerGame(minutesPlayed);
                    double fieldGoal = nf.parse(String.valueOf(row1.get(i).getCell(6).asNormalizedText())).doubleValue();
                    bs1.setFieldGoalsMadePerGame(fieldGoal);
                    double fieldAttempted = nf.parse(String.valueOf(row1.get(i).getCell(7).asNormalizedText())).doubleValue();
                    bs1.setFieldGoalsAttemptedPerGame(fieldAttempted);
                    double fieldPercentage = nf.parse(String.valueOf(row1.get(i).getCell(8).asNormalizedText())).doubleValue();
                    bs1.setFieldGoalPercentage(fieldPercentage);
                    double threePoints = nf.parse(String.valueOf(row1.get(i).getCell(9).asNormalizedText())).doubleValue();
                    bs1.setThreePointsAveragePerGame(threePoints);
                    double threesAttempted = nf.parse(String.valueOf(row1.get(i).getCell(10).asNormalizedText())).doubleValue();
                    bs1.setThreePointsAttemptedPerGame(threesAttempted);
                    double twoPointsMade = nf.parse(String.valueOf(row1.get(i).getCell(12).asNormalizedText())).doubleValue();
                    bs1.setTwoPointFieldGoalsPerGame(twoPointsMade);
                    double twoPointAtt = nf.parse(String.valueOf(row1.get(i).getCell(13).asNormalizedText())).doubleValue();
                    bs1.setTwoPointAverageAttemptedPerGame(twoPointAtt);
                    double freeThrow= nf.parse(String.valueOf(row1.get(i).getCell(16).asNormalizedText())).doubleValue();
                    bs1.setFreeThrowsPerGame(freeThrow);
                    double freeThrowAtt = nf.parse(String.valueOf(row1.get(i).getCell(17).asNormalizedText())).doubleValue();
                    bs1.setFreeThrowsAttemptedPerGame(freeThrowAtt);
                    double rebounds = nf.parse(String.valueOf(row1.get(i).getCell(21).asNormalizedText())).doubleValue();
                    bs1.setReboundsPerGame(rebounds);
                    double assist = nf.parse(String.valueOf(row1.get(i).getCell(22).asNormalizedText())).doubleValue();
                    bs1.setAssistPerGame(assist);
                    double steal = nf.parse(String.valueOf(row1.get(i).getCell(23).asNormalizedText())).doubleValue();
                    bs1.setStealsPerGame(steal);
                    double blocks = nf.parse(String.valueOf(row1.get(i).getCell(24).asNormalizedText())).doubleValue();
                    bs1.setBlocksPergame(blocks);
                    double turnover = nf.parse(String.valueOf(row1.get(i).getCell(25).asNormalizedText())).doubleValue();
                    bs1.setTurnoversPerGame(turnover);
                    double fouls = nf.parse(String.valueOf(row1.get(i).getCell(26).asNormalizedText())).doubleValue();
                    bs1.setFoulsPerGame(fouls);
                    double points = nf.parse(String.valueOf(row1.get(i).getCell(27).asNormalizedText())).doubleValue();
                    bs1.setPointsPerGame(points);
                    asb.add(bs1);
                }
                System.out.println("First Team added");
                HtmlPage page2 = client.getPage(searchUrl2);
                final HtmlTable table2 = page2.getHtmlElementById("playoffs_per_game");
                List<HtmlTableRow> row2 = null;
                System.out.println("Adding second team");
                for (final HtmlTableBody body : table2.getBodies()){
                    row2 = body.getRows();
                }
                for (int i = 0; i < row2.size(); i++){
                    AllSingleBasketballPlayers bs2 = new AllSingleBasketballPlayers();
                    String name = String.valueOf(row2.get(i).getCell(1).asNormalizedText());
                    bs2.setName(name);
                    int gamesPlayed = Integer.parseInt( String.valueOf(row2.get(i).getCell(3).asNormalizedText()));
                    bs2.setGamesPlayed(gamesPlayed);
                    int gamesStarted= Integer.parseInt( String.valueOf(row2.get(i).getCell(4).asNormalizedText()));
                    bs2.setGamesStarted(gamesStarted);
                    double minutesPlayed = Double.parseDouble(String.valueOf(row2.get(i).getCell(5).asNormalizedText()));
                    bs2.setMinPerGame(minutesPlayed);
                    double fieldGoal = Double.parseDouble(String.valueOf(row2.get(i).getCell(6).asNormalizedText()));
                    bs2.setFieldGoalsMadePerGame(fieldGoal);
                    double fieldAttempted = Double.parseDouble(String.valueOf(row2.get(i).getCell(7).asNormalizedText()));
                    bs2.setFieldGoalsAttemptedPerGame(fieldAttempted);
                    double fieldPercentage = Double.parseDouble(String.valueOf(row2.get(i).getCell(8).asNormalizedText()));
                    bs2.setFieldGoalPercentage(fieldPercentage);
                    double threePoints = Double.parseDouble(String.valueOf(row2.get(i).getCell(9).asNormalizedText()));
                    bs2.setThreePointsAveragePerGame(threePoints);
                    double threesAttempted = Double.parseDouble(String.valueOf(row2.get(i).getCell(10).asNormalizedText()));
                    bs2.setThreePointsAttemptedPerGame(threesAttempted);
                    double twoPointsMade = Double.parseDouble(String.valueOf(row2.get(i).getCell(12).asNormalizedText()));
                    bs2.setTwoPointFieldGoalsPerGame(twoPointsMade);
                    double twoPointAtt = Double.parseDouble(String.valueOf(row2.get(i).getCell(13).asNormalizedText()));
                    bs2.setTwoPointAverageAttemptedPerGame(twoPointAtt);
                    double freeThrow= Double.parseDouble(String.valueOf(row2.get(i).getCell(16).asNormalizedText()));
                    bs2.setFreeThrowsPerGame(freeThrow);
                    double freeThrowAtt = Double.parseDouble(String.valueOf(row2.get(i).getCell(17).asNormalizedText()));
                    bs2.setFreeThrowsAttemptedPerGame(freeThrowAtt);
                    double rebounds = Double.parseDouble(String.valueOf(row2.get(i).getCell(21).asNormalizedText()));
                    bs2.setReboundsPerGame(rebounds);
                    double assist = Double.parseDouble(String.valueOf(row2.get(i).getCell(22).asNormalizedText()));
                    bs2.setAssistPerGame(assist);
                    double steal = Double.parseDouble(String.valueOf(row2.get(i).getCell(23).asNormalizedText()));
                    bs2.setStealsPerGame(steal);
                    double blocks = Double.parseDouble(String.valueOf(row2.get(i).getCell(24).asNormalizedText()));
                    bs2.setBlocksPergame(blocks);
                    double turnover = Double.parseDouble(String.valueOf(row2.get(i).getCell(25).asNormalizedText()));
                    bs2.setTurnoversPerGame(turnover);
                    double fouls = Double.parseDouble(String.valueOf(row2.get(i).getCell(26).asNormalizedText()));
                    bs2.setFoulsPerGame(fouls);
                    double points = Double.parseDouble(String.valueOf(row2.get(i).getCell(27).asNormalizedText()));
                    bs2.setPointsPerGame(points);
                    asb.add(bs2);
                }
                System.out.println("Second team added");
            }catch(IOException e){
                System.out.println("Error retrieving first");
                e.getCause();
                e.printStackTrace();
            }

        }catch(Exception e){
            System.out.println("Error retrieving from web client");
            e.getCause();
            e.printStackTrace();
        }
        List<AllSingleBasketballPlayers> fromCSV = getPlayersFromCSV();
        List<AllSingleBasketballPlayers> addAllPlayers = new ArrayList<>();
        System.out.println("Adding all players to one class");
        for (int i = 0; i < fromCSV.size(); i++){

            for(int j = 0; j < asb.size(); j++){
                AllSingleBasketballPlayers all = new AllSingleBasketballPlayers();
                if(Objects.equals(asb.get(j).getName(), fromCSV.get(i).getName())){
                    all.setName(fromCSV.get(i).getName());
                    all.setSalary(fromCSV.get(i).getSalary());
                    all.setId(fromCSV.get(i).getId());
                    all.setAverageFantasyPoints(fromCSV.get(i).getAverageFantasyPoints());
                    all.setPosition(fromCSV.get(i).getPosition());
                    all.setTeam(fromCSV.get(i).getTeam());
                    all.setGamesPlayed(asb.get(j).getGamesPlayed());
                    all.setGamesStarted(asb.get(j).getGamesStarted());
                    all.setMinPerGame(asb.get(j).getMinPerGame());
                    all.setFieldGoalsMadePerGame(asb.get(j).getFieldGoalsMadePerGame());
                    all.setFieldGoalsAttemptedPerGame(asb.get(j).getFieldGoalsAttemptedPerGame());
                    all.setFieldGoalPercentage(asb.get(j).getFieldGoalPercentage());
                    all.setThreePointsAveragePerGame(asb.get(j).getThreePointsAveragePerGame());
                    all.setThreePointsAttemptedPerGame(asb.get(j).getThreePointsAttemptedPerGame());
                    all.setTwoPointFieldGoalsPerGame(asb.get(j).getTwoPointFieldGoalsPerGame());
                    all.setTwoPointAverageAttemptedPerGame(asb.get(j).getTwoPointAverageAttemptedPerGame());
                    all.setTwoPointPercentagePerGame(asb.get(j).getTwoPointPercentagePerGame());
                    all.setFreeThrowsPerGame(asb.get(j).getFreeThrowsPerGame());
                    all.setFreeThrowsAttemptedPerGame(asb.get(j).getFreeThrowsAttemptedPerGame());
                    all.setFreeThrowPercentagePerGame(asb.get(j).getFreeThrowPercentagePerGame());
                    all.setReboundsPerGame(asb.get(j).getReboundsPerGame());
                    all.setAssistPerGame(asb.get(j).getAssistPerGame());
                    all.setStealsPerGame(asb.get(j).getStealsPerGame());
                    all.setBlocksPergame(asb.get(j).getBlocksPergame());
                    all.setTurnoversPerGame(asb.get(j).getTurnoversPerGame());
                    all.setFoulsPerGame(asb.get(j).getFoulsPerGame());
                    all.setPointsPerGame(asb.get(j).getPointsPerGame());
                    addAllPlayers.add(all);
                    break;
                }
            }
        }
        System.out.println("All players added to one class");
        return addAllPlayers;
    }

}
