package org.yarrnyarmy.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.yarrnyarmy.model.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AllBasketballGameServices {



    public List<AllGameBasketballPlayers> addAllPlayers() {
        List<AllGameBasketballPlayers> basketball = new ArrayList<>();
    try{

        //System.out.println("Select the file with all the players");
            String myObj = "C:\\Users\\Yarnell\\Desktop\\FantasySportsAPI\\AllTeamsBasketball\\raw.json";
            JsonElement fileElement = JsonParser.parseReader(new FileReader(myObj));
            JsonObject jsonObject = fileElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.get("draftables").getAsJsonArray();
            for(JsonElement nameElement : jsonArray) {
                int length = basketball.size();
                AllGameBasketballPlayers allGame = new AllGameBasketballPlayers();
                JsonObject nameJson = nameElement.getAsJsonObject();
                allGame.setFirstName(nameJson.get("firstName").getAsString());
                allGame.setLastName(nameJson.get("lastName").getAsString());
                if(basketball.isEmpty() || !Objects.equals(allGame.getLastName(), basketball.get(length - 1).getLastName())){
                    allGame.setDisabled(nameJson.get("isDisabled").getAsBoolean());
                    allGame.setPosition(nameJson.get("position").getAsString());
                    allGame.setSalary(nameJson.get("salary").getAsInt());
                    allGame.setTeam(nameJson.get("teamAbbreviation").getAsString());
                    allGame.setPlayerDraftKingsId(nameJson.get("draftableId").getAsLong());

                    //get stats information in array and add it to draftkingsAverage
                    JsonArray statsArray = nameJson.getAsJsonArray("draftStatAttributes");

                    //get the first value in the array and add it to the draft points average
                    JsonElement averagePoints = statsArray.get(0);
                    JsonObject pointsObject = averagePoints.getAsJsonObject();
                    String fantasyPoints = pointsObject.get("value").getAsString();
                    double d = 0;
                    if(!allGame.getDisabled()){
                        if(Objects.equals(fantasyPoints, "-")){
                            fantasyPoints = "0";
                        }

                        for(int i = 0; i < fantasyPoints.length(); i++){
                           char c = fantasyPoints.charAt(i);
                            if (c == 't' || c == 'h' || c == 'n' || c == 'd') {
                                fantasyPoints = "0";
                            }
                        }
                        d = Double.parseDouble(fantasyPoints);
                    }
                    if(d > 5){
                        allGame.setDraftKingsFantasyPoints(d);
                        basketball.add(allGame);
                    }

                }

            }

        }catch(FileNotFoundException e){
        e.getCause();
        }
    return basketball;
    }

    public List<BasketballAllGamePG> getAllPG(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGamePG> allPG = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGamePG bp = new BasketballAllGamePG();
            if(Objects.equals(person.getPosition(), "PG") || Objects.equals(person.getPosition(), "PG/SG")){
                bp.setFirstName(person.getFirstName());
                bp.setLastName(person.getLastName());
                bp.setPosition(person.getPosition());
                bp.setTeam(person.getTeam());
                bp.setSalary(person.getSalary());
                bp.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                bp.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                bp.setDisabled(person.getDisabled());
                allPG.add(bp);
            }
        }

        for(BasketballAllGamePG allPgs: allPG){
            System.out.println(allPgs);
        }
        return allPG;
    }

    public List<BasketballAllGameSG> getAllSG(){
            List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
            List<BasketballAllGameSG> allSG = new ArrayList<>();
            for(AllGameBasketballPlayers person : allPlayers){
                BasketballAllGameSG sg = new BasketballAllGameSG();
                if(Objects.equals(person.getPosition(), "SG") || Objects.equals(person.getPosition(), "PG/SG") || Objects.equals(person.getPosition(), "SG/SF")){
                    sg.setFirstName(person.getFirstName());
                    sg.setLastName(person.getLastName());
                    sg.setPosition(person.getPosition());
                    sg.setTeam(person.getTeam());
                    sg.setSalary(person.getSalary());
                    sg.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                    sg.setDisabled(person.getDisabled());
                    sg.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                    allSG.add(sg);
                }
            }

            for(BasketballAllGameSG allSgs: allSG){
                System.out.println(allSgs);
            }
            return allSG;
    }

    public List<BasketballAllGameSF> getAllSF(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGameSF> allSF = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGameSF sf = new BasketballAllGameSF();
            if(Objects.equals(person.getPosition(), "SF") || Objects.equals(person.getPosition(), "SG/SF") || Objects.equals(person.getPosition(), "SF/PF")){
                sf.setFirstName(person.getFirstName());
                sf.setLastName(person.getLastName());
                sf.setPosition(person.getPosition());
                sf.setTeam(person.getTeam());
                sf.setSalary(person.getSalary());
                sf.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                sf.setDisabled(person.getDisabled());
                sf.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                allSF.add(sf);
            }
        }

        for(BasketballAllGameSF allSfs: allSF){
            System.out.println(allSfs);
        }
        return allSF;
    }

    public List<BasketballAllGamePF> getAllPF(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGamePF> allPF = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGamePF pf = new BasketballAllGamePF();
            if(Objects.equals(person.getPosition(), "PF") || Objects.equals(person.getPosition(), "SF/PF") || Objects.equals(person.getPosition(), "PF/C")){
                pf.setFirstName(person.getFirstName());
                pf.setLastName(person.getLastName());
                pf.setPosition(person.getPosition());
                pf.setTeam(person.getTeam());
                pf.setSalary(person.getSalary());
                pf.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                pf.setDisabled(person.getDisabled());
                pf.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                allPF.add(pf);
            }
        }

        for(BasketballAllGamePF allPfs: allPF){
            System.out.println(allPfs);
        }
        return allPF;
    }

    public void showAllPlayers(){
        List<AllGameBasketballPlayers> people = addAllPlayers();
        int count = 1;
        for(AllGameBasketballPlayers person: people){
            System.out.println(count + " " + person.getLastName() + " " +person.getDraftKingsFantasyPoints() + " " + person.getDisabled());
            System.out.println();
            count++;
        }
    }
}
