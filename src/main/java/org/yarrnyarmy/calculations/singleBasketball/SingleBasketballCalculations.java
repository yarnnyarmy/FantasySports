package org.yarrnyarmy.calculations.singleBasketball;

import net.sourceforge.htmlunit.corejs.javascript.serialize.ScriptableOutputStream;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballCpt;

import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballUtil;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBestTeams;

import org.yarrnyarmy.services.singleBasketballGames.SingleBasketballGameServices;

import java.util.*;


public class SingleBasketballCalculations {
SingleBasketballGameServices sb = new SingleBasketballGameServices();
    public List<SingleBestTeams> getBestTeams() {

        List<SingleBasketballCpt> cptPlayers = sb.getAllCpts();
        List<SingleBasketballUtil> utilPlayers = sb.getAllUitls();
        List<SingleBestTeams> singleBestTeams = new ArrayList<>();
        System.out.println("Getting the best team possibilities");
        int count = 0;
        for (int a = 0; a < cptPlayers.size(); a++) {
            for (int b = 0; b < utilPlayers.size(); b++) {
                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(b).getName())) {
                    for (int c = 0; c < utilPlayers.size(); c++) {
                        if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(c).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(c).getId())) {
                            for (int d = 0; d < utilPlayers.size(); d++) {
                                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(d).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(d).getId())
                                        && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(d).getId())) {
                                    for (int e = 0; e < utilPlayers.size(); e++) {
                                        if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(e).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(e).getId())
                                                && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(e).getId()) && !Objects.equals(utilPlayers.get(d).getId(), utilPlayers.get(e).getId())) {
                                            for (int f = 0; f < utilPlayers.size(); f++) {
                                                SingleBestTeams bestTeam = new SingleBestTeams();
                                                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(f).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(f).getId())
                                                        && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(f).getId()) && !Objects.equals(utilPlayers.get(d).getId(), utilPlayers.get(f).getId()) &&
                                                        !Objects.equals(utilPlayers.get(e).getId(), utilPlayers.get(f).getId())) {
                                                    if (!Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(b).getTeam()) || !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(c).getTeam()) ||
                                                            !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(d).getTeam()) || !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(e).getTeam()) ||
                                                            !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(f).getTeam())) {
                                                        {
                                                            // get the average of mins of all 6 players.
                                                            double minsPerGame = Math.round(((cptPlayers.get(a).getMinPerGame() + utilPlayers.get(b).getMinPerGame() + utilPlayers.get(c).getMinPerGame() + utilPlayers.get(d).getMinPerGame()
                                                                    + utilPlayers.get(e).getMinPerGame() + utilPlayers.get(f).getMinPerGame()) / 6) * 1000) / 1000;

                                                            // total games played
                                                            int gamesPlayed = cptPlayers.get(a).getGamesPlayed() + utilPlayers.get(b).getGamesPlayed() + utilPlayers.get(c).getGamesPlayed() + utilPlayers.get(d).getGamesPlayed()
                                                                    + utilPlayers.get(e).getGamesPlayed() + utilPlayers.get(f).getGamesPlayed();

                                                            // total games started
                                                            int gamesStarted = cptPlayers.get(a).getGamesStarted() + utilPlayers.get(b).getGamesPlayed() + utilPlayers.get(c).getGamesPlayed() + utilPlayers.get(d).getGamesPlayed()
                                                                    + utilPlayers.get(e).getGamesPlayed() + utilPlayers.get(f).getGamesPlayed();

                                                            // average assist for each team
                                                            double assist = Math.round(((cptPlayers.get(a).getAssistPerGame() + utilPlayers.get(b).getAssistPerGame() + utilPlayers.get(c).getAssistPerGame() + utilPlayers.get(d).getAssistPerGame()
                                                                    + utilPlayers.get(e).getAssistPerGame() + utilPlayers.get(f).getAssistPerGame()) / 6) * 1000) / 1000 ;

                                                            // if the salary of all the players are less than or equal to 50000, then proceed
                                                            int totalSalary = cptPlayers.get(a).getSalary() + utilPlayers.get(b).getSalary() + utilPlayers.get(c).getSalary() + utilPlayers.get(d).getSalary() +
                                                                    utilPlayers.get(e).getSalary() + utilPlayers.get(f).getSalary();

                                                            // average field goals per game made
                                                            double fieldGoalsMade = Math.round(((cptPlayers.get(a).getFieldGoalsMadePerGame() + utilPlayers.get(b).getFieldGoalsMadePerGame() + utilPlayers.get(c).getFieldGoalsMadePerGame()
                                                                    + utilPlayers.get(d).getFieldGoalsMadePerGame() + utilPlayers.get(e).getFieldGoalsMadePerGame() + utilPlayers.get(f).getFieldGoalsMadePerGame()) / 6) * 1000) / 1000;

                                                            // average field goals attempted per game
                                                            double fieldGoalsAttempted = Math.round(((cptPlayers.get(a).getFieldGoalsAttemptedPerGame() + utilPlayers.get(b).getFieldGoalsAttemptedPerGame() + utilPlayers.get(c).getFieldGoalsAttemptedPerGame()
                                                                    + utilPlayers.get(d).getFieldGoalsAttemptedPerGame() + utilPlayers.get(e).getFieldGoalsAttemptedPerGame() + utilPlayers.get(f).getFieldGoalsAttemptedPerGame()) / 6) * 1000) / 1000;


                                                            // get average three pointers made per game
                                                            double threePointsMade = Math.round(((cptPlayers.get(a).getThreePointsAveragePerGame() + utilPlayers.get(b).getThreePointsAveragePerGame() + utilPlayers.get(c).getThreePointsAveragePerGame()
                                                                    + utilPlayers.get(d).getThreePointsAveragePerGame() + utilPlayers.get(e).getThreePointsAveragePerGame() + utilPlayers.get(f).getThreePointsAveragePerGame()) / 6) * 1000) / 1000;

                                                            // get average three pointers attempted per game
                                                            double threesAttempted = Math.round(((cptPlayers.get(a).getThreePointsAttemptedPerGame() + utilPlayers.get(b).getThreePointsAttemptedPerGame() + + utilPlayers.get(c).getThreePointsAttemptedPerGame()
                                                                    + utilPlayers.get(d).getThreePointsAttemptedPerGame() + utilPlayers.get(e).getThreePointsAttemptedPerGame() + utilPlayers.get(f).getThreePointsAttemptedPerGame()) / 6) * 1000) / 1000;

                                                            // get average two pointers per game
                                                            double twoPointAverage = Math.round(((cptPlayers.get(a).getTwoPointFieldGoalsPerGame() + utilPlayers.get(b).getTwoPointFieldGoalsPerGame() + utilPlayers.get(c).getTwoPointFieldGoalsPerGame()
                                                                    + utilPlayers.get(d).getTwoPointFieldGoalsPerGame() + utilPlayers.get(e).getTwoPointFieldGoalsPerGame() + utilPlayers.get(f).getTwoPointFieldGoalsPerGame()) / 6) * 1000) / 1000;

                                                            // get average two pointers attempted per game
                                                            double twoPointAtt = Math.round(((cptPlayers.get(a).getTwoPointAverageAttemptedPerGame()  + utilPlayers.get(b).getTwoPointAverageAttemptedPerGame() + utilPlayers.get(c).getTwoPointAverageAttemptedPerGame()
                                                                    + utilPlayers.get(d).getTwoPointAverageAttemptedPerGame() + utilPlayers.get(e).getTwoPointAverageAttemptedPerGame() + utilPlayers.get(f).getTwoPointAverageAttemptedPerGame()) / 6) * 1000) / 1000;

                                                            // get average two point percentage

                                                            // get average free throws
                                                            double freeThrows = Math.round(((cptPlayers.get(a).getFreeThrowsPerGame() + utilPlayers.get(b).getFreeThrowsPerGame() + utilPlayers.get(c).getFreeThrowsPerGame()
                                                                    + utilPlayers.get(d).getFreeThrowsPerGame() + utilPlayers.get(e).getFreeThrowsPerGame() + utilPlayers.get(f).getFreeThrowsPerGame()) / 6) * 1000) / 1000;

                                                            // get free throws attempt per game
                                                            double freeThrowAtt = Math.round(((cptPlayers.get(a).getFreeThrowsAttemptedPerGame() + utilPlayers.get(b).getFreeThrowsAttemptedPerGame() + utilPlayers.get(c).getFreeThrowsAttemptedPerGame()
                                                                    + utilPlayers.get(d).getFreeThrowsAttemptedPerGame() + utilPlayers.get(e).getFreeThrowsAttemptedPerGame() + utilPlayers.get(f).getFreeThrowsAttemptedPerGame()) / 6) * 1000) / 1000;

                                                            // get free throw percentage
                                                            //double freeThrowPerc = (cptPlayers.get(a).getFreeThrowPercentagePerGame() + utilPlayers.get(b).getThreePointPercentagePerGame() + utilPlayers.get(c).getThreePointPercentagePerGame()
                                                                    //+ utilPlayers.get(d).getThreePointPercentagePerGame() + utilPlayers.get(e).getThreePointPercentagePerGame() + utilPlayers.get(f).getThreePointPercentagePerGame()) / 6;

                                                            // get average steals per game
                                                            double steals = Math.round(((cptPlayers.get(a).getStealsPerGame() + utilPlayers.get(b).getStealsPerGame() + utilPlayers.get(c).getStealsPerGame()
                                                                    + utilPlayers.get(d).getStealsPerGame() + utilPlayers.get(e).getStealsPerGame() + utilPlayers.get(f).getStealsPerGame()) / 6) * 1000) / 1000;

                                                            // get average blocks per game
                                                            double blocks = Math.round(((cptPlayers.get(a).getBlocksPergame() + utilPlayers.get(b).getBlocksPergame() + utilPlayers.get(c).getBlocksPergame()
                                                                    + utilPlayers.get(d).getBlocksPergame() + utilPlayers.get(e).getBlocksPergame() + utilPlayers.get(f).getBlocksPergame()) / 6) * 1000) / 1000;

                                                            // get average turnovers per game
                                                            double turnover = Math.round(((cptPlayers.get(a).getTurnoversPerGame() + utilPlayers.get(b).getTurnoversPerGame() + utilPlayers.get(c).getTurnoversPerGame()
                                                                    + utilPlayers.get(d).getTurnoversPerGame() + utilPlayers.get(e).getTurnoversPerGame() + utilPlayers.get(f).getTurnoversPerGame()) / 6) * 1000) / 1000;

                                                            // get average fouls per game
                                                            double fouls = (((cptPlayers.get(a).getFoulsPerGame() + utilPlayers.get(b).getFoulsPerGame() + utilPlayers.get(c).getFoulsPerGame()
                                                                    + utilPlayers.get(d).getFoulsPerGame() + utilPlayers.get(e).getFoulsPerGame() + utilPlayers.get(f).getFoulsPerGame()) / 6) * 1000) / 1000;

                                                            //get average points per game
                                                            double points = Math.round(((cptPlayers.get(a).getPointsPerGame() + utilPlayers.get(b).getPointsPerGame() + utilPlayers.get(c).getPointsPerGame()
                                                                    + utilPlayers.get(d).getPointsPerGame() + utilPlayers.get(e).getPointsPerGame() + utilPlayers.get(f).getPointsPerGame()) / 6) * 1000) / 1000;
                                                            if (totalSalary <= 50000){
                                                                // gets the total fantasy points per game
                                                                double totalPoints = (cptPlayers.get(a).getAverageFantasyPoints() * 1.5) + utilPlayers.get(b).getAverageFantasyPoints() + utilPlayers.get(c).getAverageFantasyPoints() + utilPlayers.get(d).getPointsPerGame() +
                                                                        utilPlayers.get(e).getAverageFantasyPoints() + utilPlayers.get(f).getAverageFantasyPoints();

                                                                long allId = cptPlayers.get(a).getId() + utilPlayers.get(b).getId() + utilPlayers.get(c).getId() + utilPlayers.get(d).getId() + utilPlayers.get(e).getId()
                                                                        + utilPlayers.get(f).getId();
                                                                bestTeam.setSalary(totalSalary);
                                                                bestTeam.setAverageFantasyPoints(totalPoints);
                                                                bestTeam.setCpt(cptPlayers.get(a).getName());
                                                                bestTeam.setUtil1(utilPlayers.get(b).getName());
                                                                bestTeam.setUtil2(utilPlayers.get(c).getName());
                                                                bestTeam.setUtil3(utilPlayers.get(d).getName());
                                                                bestTeam.setUtil4(utilPlayers.get(e).getName());
                                                                bestTeam.setUtil5(utilPlayers.get(f).getName());
                                                                bestTeam.setPlayersId(allId);
                                                                bestTeam.setMinPerGame(minsPerGame);
                                                                bestTeam.setGamesPlayed(gamesPlayed);
                                                                bestTeam.setGamesStarted(gamesStarted);
                                                                bestTeam.setAssistPerGame(assist);
                                                                bestTeam.setFieldGoalsMadePerGame(fieldGoalsMade);
                                                                bestTeam.setFieldGoalsAttemptedPerGame(fieldGoalsAttempted);
                                                                //bestTeam.setFieldGoalPercentage(fieldGoalPerc);
                                                                bestTeam.setThreePointsAveragePerGame(threePointsMade);
                                                                bestTeam.setThreePointsAttemptedPerGame(threesAttempted);
                                                                //bestTeam.setThreePointPercentagePerGame(threePercentage);
                                                                bestTeam.setTwoPointFieldGoalsPerGame(twoPointAverage);
                                                                bestTeam.setTwoPointAverageAttemptedPerGame(twoPointAtt);
                                                                //bestTeam.setTwoPointPercentagePerGame(twoPointperc);
                                                                bestTeam.setFreeThrowsPerGame(freeThrows);
                                                                bestTeam.setFreeThrowsAttemptedPerGame(freeThrowAtt);
                                                                //bestTeam.setFreeThrowPercentagePerGame(freeThrowPerc);
                                                                bestTeam.setStealsPerGame(steals);
                                                                bestTeam.setBlocksPerGame(blocks);
                                                                bestTeam.setTurnoversPerGame(turnover);
                                                                bestTeam.setFoulsPerGame(fouls);
                                                                bestTeam.setPointsPerGame(points);

                                                                    if(singleBestTeams.size() < 18000000) {
                                                                        singleBestTeams.add(bestTeam);
                                                                    }

                                                            }

                                                        }

                                                    }

                                                }

                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

        System.out.println("Sorting teams by fantasy points");
        System.out.println("The size of single best teams is : " + singleBestTeams.size());
        System.out.println("Sorting single best teams");
        Collections.sort(singleBestTeams, Comparator.comparing(SingleBestTeams::getCpt).thenComparingDouble(SingleBestTeams::getAverageFantasyPoints));
        System.out.println("");
        Collections.reverse(singleBestTeams);
        System.out.println("All players sorted with collection");

        System.out.println("Filtering the list");
        List<SingleBestTeams> distinct = new ArrayList<>();
        for(int i = 0; i < singleBestTeams.size(); i++){
            if(i == 0){
                distinct.add(singleBestTeams.get(i));
            }
            if(i > 0){
                if(singleBestTeams.get(i).getCpt().equals(singleBestTeams.get(i - 1).getCpt())){
                    if(singleBestTeams.get(i).getAverageFantasyPoints() != singleBestTeams.get(i - 1).getAverageFantasyPoints()
                            && singleBestTeams.get(i).getSalary() != singleBestTeams.get(i - 1).getSalary()){
                        distinct.add(singleBestTeams.get(i));
                    }
                }
            }
            if(i > 0){
                if(!Objects.equals(singleBestTeams.get(i).getCpt(), singleBestTeams.get(i - 1).getCpt())){
                    distinct.add(singleBestTeams.get(i));
                }
            }
        }

        System.out.println("List filtered");
        System.out.println("Sorting filtered distinct list");
        System.out.println("After filtering the size of distinct is : " + distinct.size());
        Collections.sort(distinct, Comparator.comparingDouble(SingleBestTeams::getAverageFantasyPoints));
        Collections.reverse(distinct);
        return distinct;
    }

    }

