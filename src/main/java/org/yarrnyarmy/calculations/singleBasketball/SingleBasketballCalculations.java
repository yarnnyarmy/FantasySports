package org.yarrnyarmy.calculations.singleBasketball;

import org.yarrnyarmy.model.AllBasketballGames.BestTeams;
import org.yarrnyarmy.model.MySqlConnection;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballCpt;

import org.yarrnyarmy.model.SingleBasketballGames.SingleBasketballUtil;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBestTeams;

import org.yarrnyarmy.services.singleBasketballGames.SingleBasketballGameServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class SingleBasketballCalculations {

    SingleBasketballGameServices sb = new SingleBasketballGameServices();

    public List<SingleBestTeams> getBestTeams() {
        List<SingleBasketballCpt> cptPlayers = sb.getAllCpts();
        List<SingleBasketballUtil> utilPlayers = sb.getAllUitls();
        List<SingleBestTeams> singleBestTeams = new ArrayList<>();
        for (int a = 0; a < cptPlayers.size(); a++) {
            for (int b = 0; b < utilPlayers.size(); b++) {
                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(b).getName())) {
                    for (int c = b + 1; c < utilPlayers.size(); c++) {
                        if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(c).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(c).getId())) {
                            for (int d = c + 1; d < utilPlayers.size(); d++) {
                                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(d).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(d).getId())
                                        && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(d).getId())) {
                                    for (int e = d + 1; e < utilPlayers.size(); e++) {
                                        if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(e).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(e).getId())
                                                && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(e).getId()) && !Objects.equals(utilPlayers.get(d).getId(), utilPlayers.get(e).getId())) {
                                            for (int f = e + 1; f < utilPlayers.size(); f++) {
                                                SingleBestTeams bestTeam = new SingleBestTeams();
                                                if (!Objects.equals(cptPlayers.get(a).getName(), utilPlayers.get(f).getName()) && !Objects.equals(utilPlayers.get(b).getId(), utilPlayers.get(f).getId())
                                                        && !Objects.equals(utilPlayers.get(c).getId(), utilPlayers.get(f).getId()) && !Objects.equals(utilPlayers.get(d).getId(), utilPlayers.get(f).getId()) &&
                                                        !Objects.equals(utilPlayers.get(e).getId(), utilPlayers.get(f).getId())) {
                                                    if (!Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(b).getTeam()) && !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(c).getTeam()) &&
                                                            !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(d).getTeam()) && !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(e).getTeam()) &&
                                                            !Objects.equals(cptPlayers.get(a).getTeam(), utilPlayers.get(f).getTeam())) {
                                                        {
                                                            int totalSalary = cptPlayers.get(a).getSalary() + utilPlayers.get(b).getSalary() + utilPlayers.get(c).getSalary() + utilPlayers.get(d).getSalary() +
                                                                    utilPlayers.get(e).getSalary() + utilPlayers.get(f).getSalary();

                                                            if (totalSalary <= 50000) {

                                                                double totalPoints = cptPlayers.get(a).getAveragePoints() + utilPlayers.get(b).getAveragePoints() + utilPlayers.get(c).getAveragePoints() + utilPlayers.get(d).getAveragePoints() +
                                                                        utilPlayers.get(e).getAveragePoints() + utilPlayers.get(f).getAveragePoints();

                                                                bestTeam.setSalary(totalSalary);
                                                                bestTeam.setAveragePoints(totalPoints);
                                                                bestTeam.setCpt(cptPlayers.get(a).getName());
                                                                bestTeam.setUtil1(utilPlayers.get(b).getName());
                                                                bestTeam.setUtil2(utilPlayers.get(c).getName());
                                                                bestTeam.setUtil3(utilPlayers.get(d).getName());
                                                                bestTeam.setUtil4(utilPlayers.get(e).getName());
                                                                bestTeam.setUtil5(utilPlayers.get(f).getName());

                                                                if (singleBestTeams.size() < 20000000) {
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
        Collections.sort(singleBestTeams, Comparator.comparingDouble(SingleBestTeams::getAveragePoints));
        Collections.reverse(singleBestTeams);
        return singleBestTeams;
    }

    public void addToDatabase(){
        List<SingleBestTeams> singleBestTeams = getBestTeams();
        MySqlConnection connection = new MySqlConnection();
        if (singleBestTeams.size() > 0){
            try{
               Connection connect =  connection.sqlConnection();
                System.out.println("Inserting all records...");
                for (SingleBestTeams allTeams : singleBestTeams){
                    String sql = "INSERT INTO singlegamebasketball (Cpt, Util1, Util2, Util3, Util4, Util5, TotalSalary, TotalPoints) " +
                                                                    "VALUES (?,?,?,?,?,?,?,?)";

                    PreparedStatement myStmt = connect.prepareStatement(sql);

                    myStmt.setString(1, allTeams.getCpt());
                    myStmt.setString(2, allTeams.getUtil1());
                    myStmt.setString(3, allTeams.getUtil2());
                    myStmt.setString(4, allTeams.getUtil3());
                    myStmt.setString(5, allTeams.getUtil4());
                    myStmt.setString(6, allTeams.getUtil5());
                    myStmt.setInt(7, allTeams.getSalary());
                    myStmt.setDouble(8, allTeams.getAveragePoints());
                    myStmt.executeUpdate();
                }
                System.out.println("All records added...");
            }catch(SQLException e) {
                e.printStackTrace();
                e.getCause();
            }
        }else{
            System.out.println("There are no teams to add.");
        }
    }

}
