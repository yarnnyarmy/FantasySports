package org.yarrnyarmy.services.singleBasketballGames;

import org.yarrnyarmy.model.SingleBasketballGames.AllSingleBasketballPlayers;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballCpt;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballUtil;

import java.util.*;

public class SingleBasketballGameServices {

    ConvertFromCSV cs = new ConvertFromCSV();

    public List<SingleBasketballCpt> getAllCpts(){
        List<AllSingleBasketballPlayers> allPlayers = cs.getPlayersFromCSV();
        List<SingleBasketballCpt> allCpts = new ArrayList<>();

        for(AllSingleBasketballPlayers people : allPlayers){
            SingleBasketballCpt cpt = new SingleBasketballCpt();
            if(Objects.equals(people.getPosition(), "CPT")){
                cpt.setName(people.getName());
                cpt.setPosition(people.getPosition());
                cpt.setTeam(people.getTeam());
                cpt.setId(people.getId());
                cpt.setSalary(people.getSalary());
                cpt.setAveragePoints(people.getAveragePoints());
                allCpts.add(cpt);
            }
        }

        for(SingleBasketballCpt person : allCpts){
            System.out.println(person.getName() + " " + " " + person.getPosition() + " " + person.getAveragePoints());
        }

        Collections.sort(allCpts, Comparator.comparingDouble(SingleBasketballCpt::getAveragePoints));
        Collections.reverse(allCpts);
        return allCpts;
    }

    public List<SingleBasketballUtil> getAllUitls(){
        List<AllSingleBasketballPlayers> allPlayers = cs.getPlayersFromCSV();
        List<SingleBasketballUtil> allUtils = new ArrayList<>();

        for(AllSingleBasketballPlayers people : allPlayers){
            SingleBasketballUtil util = new SingleBasketballUtil();
            if(Objects.equals(people.getPosition(), "UTIL")){
                util.setName(people.getName());
                util.setPosition(people.getPosition());
                util.setTeam(people.getTeam());
                util.setId(people.getId());
                util.setSalary(people.getSalary());
                util.setAveragePoints(people.getAveragePoints());
                allUtils.add(util);
            }
        }
        Collections.sort(allUtils, Comparator.comparingDouble(SingleBasketballUtil::getAveragePoints));
        Collections.reverse(getAllCpts());
        return allUtils;
    }
}
