package org.yarrnyarmy.services.singleBasketballGames;

import org.yarrnyarmy.model.SingleBasketballGames.AllSingleBasketballPlayers;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballCpt;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballUtil;

import java.util.*;

public class SingleBasketballGameServices {

    AddInformationToClass cs = new AddInformationToClass();

    public List<SingleBasketballCpt> getAllCpts() {
        List<AllSingleBasketballPlayers> allPlayersNBAReference = cs.addAllPlayers();
        List<SingleBasketballCpt> allCpts = new ArrayList<>();
        for (AllSingleBasketballPlayers people : allPlayersNBAReference) {
            SingleBasketballCpt cpt = new SingleBasketballCpt();
            if (Objects.equals(people.getPosition(), "CPT")) {
                cpt.setName(people.getName());
                cpt.setPosition(people.getPosition());
                cpt.setTeam(people.getTeam());
                cpt.setId(people.getId());
                cpt.setSalary(people.getSalary());
                cpt.setPointsPerGame(people.getPointsPerGame());
                cpt.setAssistPerGame(people.getAssistPerGame());
                cpt.setAverageFantasyPoints(people.getAverageFantasyPoints());
                cpt.setFoulsPerGame(people.getFoulsPerGame());
                cpt.setBlocksPergame(people.getBlocksPergame());
                cpt.setThreePointsAveragePerGame(people.getThreePointsAveragePerGame());
                cpt.setThreePointsAttemptedPerGame(people.getThreePointsAttemptedPerGame());
                cpt.setTwoPointFieldGoalsPerGame(people.getTwoPointFieldGoalsPerGame());
                cpt.setTwoPointAverageAttemptedPerGame(people.getTwoPointAverageAttemptedPerGame());
                cpt.setGamesPlayed(people.getGamesPlayed());
                cpt.setGamesStarted(people.getGamesStarted());
                cpt.setFoulsPerGame(people.getFoulsPerGame());
                cpt.setFieldGoalsMadePerGame(people.getFieldGoalsMadePerGame());
                cpt.setFieldGoalsAttemptedPerGame(people.getFieldGoalsAttemptedPerGame());
                cpt.setFieldGoalPercentage(people.getFieldGoalPercentage());
                cpt.setFreeThrowsPerGame(people.getFreeThrowsPerGame());
                cpt.setFreeThrowsAttemptedPerGame(people.getFreeThrowsAttemptedPerGame());
                cpt.setFreeThrowPercentagePerGame(people.getFreeThrowPercentagePerGame());
                cpt.setMinPerGame(people.getMinPerGame());
                cpt.setReboundsPerGame(people.getReboundsPerGame());
                cpt.setStealsPerGame(people.getStealsPerGame());
                cpt.setTurnoversPerGame(people.getTurnoversPerGame());
                allCpts.add(cpt);
            }

        }
        Collections.sort(allCpts, Comparator.comparingDouble(SingleBasketballCpt::getAverageFantasyPoints));
        Collections.reverse(allCpts);
        return allCpts;
    }

    public List<SingleBasketballUtil> getAllUitls(){
        List<AllSingleBasketballPlayers> allPlayersNBAReference = cs.addAllPlayers();
            List<SingleBasketballUtil> allUtils = new ArrayList<>();
            for(AllSingleBasketballPlayers people : allPlayersNBAReference){
                if(Objects.equals(people.getPosition(), "UTIL")){
                    SingleBasketballUtil util = new SingleBasketballUtil();
                    util.setName(people.getName());
                    util.setPosition(people.getPosition());
                    util.setTeam(people.getTeam());
                    util.setId(people.getId());
                    util.setSalary(people.getSalary());
                    util.setPointsPerGame(people.getPointsPerGame());
                    util.setAssistPerGame(people.getAssistPerGame());
                    util.setAverageFantasyPoints(people.getAverageFantasyPoints());
                    util.setFoulsPerGame(people.getFoulsPerGame());
                    util.setBlocksPergame(people.getBlocksPergame());
                    util.setGamesPlayed(people.getGamesPlayed());
                    util.setThreePointsAveragePerGame(people.getThreePointsAveragePerGame());
                    util.setThreePointsAttemptedPerGame(people.getThreePointsAttemptedPerGame());
                    util.setTwoPointFieldGoalsPerGame(people.getTwoPointFieldGoalsPerGame());
                    util.setTwoPointAverageAttemptedPerGame(people.getTwoPointAverageAttemptedPerGame());
                    util.setGamesStarted(people.getGamesStarted());
                    util.setFoulsPerGame(people.getFoulsPerGame());
                    util.setFieldGoalsMadePerGame(people.getFieldGoalsMadePerGame());
                    util.setFieldGoalsAttemptedPerGame(people.getFieldGoalsAttemptedPerGame());
                    util.setFieldGoalPercentage(people.getFieldGoalPercentage());
                    util.setFreeThrowsPerGame(people.getFreeThrowsPerGame());
                    util.setFreeThrowsAttemptedPerGame(people.getFreeThrowsAttemptedPerGame());
                    util.setFreeThrowPercentagePerGame(people.getFreeThrowPercentagePerGame());
                    util.setMinPerGame(people.getMinPerGame());
                    util.setReboundsPerGame(people.getReboundsPerGame());
                    util.setStealsPerGame(people.getStealsPerGame());
                    util.setTurnoversPerGame(people.getTurnoversPerGame());
                    allUtils.add(util);
                }

            }
        Collections.sort(allUtils, Comparator.comparingDouble(SingleBasketballUtil::getAverageFantasyPoints));
        Collections.reverse(allUtils);
        return allUtils;
        }

    }

