package org.yarrnyarmy.services.allBasketballGames;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.yarrnyarmy.model.AllBasketballGames.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AllBasketballGameServices {



    public List<AllGameBasketballPlayers> addAllPlayers() {
        List<AllGameBasketballPlayers> basketball = new ArrayList<>();
    try{

        //System.out.println("Select the file with all the players");
            String myObj = "C:\\Users\\Yarnell\\Desktop\\FantasySportsAPI\\AllTeamsBasketball\\05252022_Basketball\\allTeams.json";
            JsonElement fileElement = JsonParser.parseReader(new FileReader(myObj));
            JsonObject jsonObject = fileElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.get("draftables").getAsJsonArray();
            for(JsonElement nameElement : jsonArray) {
                int length = basketball.size();
                AllGameBasketballPlayers allGame = new AllGameBasketballPlayers();
                JsonObject nameJson = nameElement.getAsJsonObject();
                allGame.setFirstName(nameJson.get("firstName").getAsString());
                allGame.setLastName(nameJson.get("lastName").getAsString());
                if(basketball.isEmpty() || (!Objects.equals(allGame.getLastName(), basketball.get(length - 1).getLastName())) &&
                   !Objects.equals(allGame.getFirstName(), basketball.get(length -1).getFirstName())){
                    allGame.setDisabled(nameJson.get("isDisabled").getAsBoolean());
                    allGame.setPosition(nameJson.get("position").getAsString());
                    allGame.setSalary(nameJson.get("salary").getAsInt());
                    allGame.setTeam(nameJson.get("teamAbbreviation").getAsString());
                    allGame.setPlayerDraftKingsId(nameJson.get("draftableId").getAsLong());
                    allGame.setStatus(nameJson.get("status").getAsString());
                    //get stats information in array and add it to draftkingsAverage
                    JsonArray statsArray = nameJson.getAsJsonArray("draftStatAttributes");

                    //get the first value in the array and add it to the draft points average
                    JsonElement averagePoints = statsArray.get(0);
                    JsonObject pointsObject = averagePoints.getAsJsonObject();
                    String fantasyPoints = pointsObject.get("value").getAsString();
                    double d = 0;
                    if(!Objects.equals(allGame.getStatus(), "OUT")){
                        if(Objects.equals(fantasyPoints, "-")){
                            fantasyPoints = "0";
                        }

                        for(int i = 0; i < fantasyPoints.length(); i++){
                           char c = fantasyPoints.charAt(i);
                            if (c == 't' || c == 'h' || c == 'n' || c == 'd') {
                                fantasyPoints = "0";
                                break;
                            }
                        }
                        d = Double.parseDouble(fantasyPoints);
                    }
                    if(d > 15){
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
        Collections.sort(allPG, Comparator.comparingDouble(BasketballAllGamePG::getDraftKingsFantasyPoints));
        Collections.reverse(allPG);
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
        Collections.sort(allSG, Comparator.comparingDouble(BasketballAllGameSG::getDraftKingsFantasyPoints));
        Collections.reverse(allSG);

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
        Collections.sort(allSF, Comparator.comparingDouble(BasketballAllGameSF::getDraftKingsFantasyPoints));
        Collections.reverse(allSF);
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
        Collections.sort(allPF, Comparator.comparingDouble(BasketballAllGamePF::getDraftKingsFantasyPoints));
        Collections.reverse(allPF);
        return allPF;
    }

    public List<BasketballAllGameC> getAllC(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGameC> allC = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGameC c = new BasketballAllGameC();
            if(Objects.equals(person.getPosition(), "C")|| Objects.equals(person.getPosition(), "PF/C")){
                c.setFirstName(person.getFirstName());
                c.setLastName(person.getLastName());
                c.setPosition(person.getPosition());
                c.setTeam(person.getTeam());
                c.setSalary(person.getSalary());
                c.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                c.setDisabled(person.getDisabled());
                c.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                allC.add(c);
            }
        }
        Collections.sort(allC, Comparator.comparingDouble(BasketballAllGameC::getDraftKingsFantasyPoints));
        Collections.reverse(allC);
        return allC;
    }

    public List<BasketballAllGameG> getAllG(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGameG> allG = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGameG g = new BasketballAllGameG();
            if(Objects.equals(person.getPosition(), "PG")|| Objects.equals(person.getPosition(), "SG")
                    || Objects.equals(person.getPosition(), "PG/SG") || Objects.equals(person.getPosition(), "SG/SF")){
                g.setFirstName(person.getFirstName());
                g.setLastName(person.getLastName());
                g.setPosition(person.getPosition());
                g.setTeam(person.getTeam());
                g.setSalary(person.getSalary());
                g.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                g.setDisabled(person.getDisabled());
                g.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                allG.add(g);
            }
        }
        Collections.sort(allG, Comparator.comparingDouble(BasketballAllGameG::getDraftKingsFantasyPoints));
        Collections.reverse(allG);
        return allG;
    }

    public List<BasketballAllGameF> getAllF(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGameF> allF = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGameF f = new BasketballAllGameF();
            if(Objects.equals(person.getPosition(), "SG/SF")|| Objects.equals(person.getPosition(), "SF")
                    || Objects.equals(person.getPosition(), "PF") || Objects.equals(person.getPosition(), "PF/C")){
                f.setFirstName(person.getFirstName());
                f.setLastName(person.getLastName());
                f.setPosition(person.getPosition());
                f.setTeam(person.getTeam());
                f.setSalary(person.getSalary());
                f.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
                f.setDisabled(person.getDisabled());
                f.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
                allF.add(f);
            }
        }
        Collections.sort(allF, Comparator.comparingDouble(BasketballAllGameF::getDraftKingsFantasyPoints));
        Collections.reverse(allF);
        return allF;
    }

    public List<BasketballAllGameUtil> getAllUtil(){
        List<AllGameBasketballPlayers> allPlayers = addAllPlayers();
        List<BasketballAllGameUtil> allUtil = new ArrayList<>();
        for(AllGameBasketballPlayers person : allPlayers){
            BasketballAllGameUtil ut = new BasketballAllGameUtil();
            ut.setFirstName(person.getFirstName());
            ut.setLastName(person.getLastName());
            ut.setPosition(person.getPosition());
            ut.setTeam(person.getTeam());
            ut.setSalary(person.getSalary());
            ut.setPlayerDraftKingsId(person.getPlayerDraftKingsId());
            ut.setDisabled(person.getDisabled());
            ut.setDraftKingsFantasyPoints(person.getDraftKingsFantasyPoints());
            allUtil.add(ut);
        }
        Collections.sort(allUtil, Comparator.comparingDouble(BasketballAllGameUtil::getDraftKingsFantasyPoints));
        Collections.reverse(allUtil);
        return allUtil;
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
