package org.yarrnyarmy.doa;

import com.mysql.cj.xdevapi.Result;
import org.yarrnyarmy.calculations.singleBasketball.SingleBasketballCalculations;
import org.yarrnyarmy.model.MySqlConnection;
import org.yarrnyarmy.model.SingleBasketballGames.SingleBestTeams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingleGameDatabase {

    SingleBasketballCalculations sc = new SingleBasketballCalculations();
    MySqlConnection sqlConnection = new MySqlConnection();

    public void addToDatabase(){
        List<SingleBestTeams> singleBestTeams = sc.getBestTeams();
        MySqlConnection connection = new MySqlConnection();
        if (singleBestTeams.size() > 0){
            try{
                Connection connect =  connection.sqlConnection();
                String dropTable = "DROP TABLE IF EXISTS singlegamesbasketball";
                PreparedStatement myStmtDrop = connect.prepareStatement(dropTable);
                myStmtDrop.executeUpdate();

                final String createTable = "CREATE TABLE if not exists `singlegamesbasketball` (\n" +
                        "  `TeamId` int NOT NULL AUTO_INCREMENT,\n" +
                        "  `Cpt` varchar(100) DEFAULT NULL,\n" +
                        "  `Util1` varchar(100) DEFAULT NULL,\n" +
                        "  `Util2` varchar(100) DEFAULT NULL,\n" +
                        "  `Util3` varchar(100) DEFAULT NULL,\n" +
                        "  `Util4` varchar(100) DEFAULT NULL,\n" +
                        "  `Util5` varchar(100) DEFAULT NULL,\n" +
                        "  `TotalSalary` int DEFAULT NULL,\n" +
                        "  `TotalPoints` double DEFAULT NULL,\n" +
                        "  `PlayerId` mediumtext,\n" +
                        "  `GamesPlayed` int DEFAULT NULL,\n" +
                        "  `GamesStarted` int DEFAULT NULL,\n" +
                        "  `FieldGoalsMadePerGame` double DEFAULT NULL,\n" +
                        "  `FieldGoalsAttemptedPerGame` double DEFAULT NULL,\n" +
                        "  `ThreePointsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `ThreePointsAttemptedPerGame` double DEFAULT NULL,\n" +
                        "  `TwoPointFieldGoalsPerGame` double DEFAULT NULL,\n" +
                        "  `TwoPointAverageAttemptedPerGame` double DEFAULT NULL,\n" +
                        "  `FreeThrowsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `FreeThrowsAttemptedPerGame` double DEFAULT NULL,\n" +
                        "  `AssistAveragePerGame` double DEFAULT NULL,\n" +
                        "  `ReboundsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `StealsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `BlocksAveragePerGame` double DEFAULT NULL,\n" +
                        "  `TurnoversAveragePerGame` double DEFAULT NULL,\n" +
                        "  `FoulsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `PointsAveragePerGame` double DEFAULT NULL,\n" +
                        "  `MinutesAveragePerGame` double DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`TeamId`)\n" +
                        ") ";

                PreparedStatement myStmtCreate = connect.prepareStatement(createTable);
                myStmtCreate.executeUpdate();
                System.out.println("Inserting all records...");
                for (SingleBestTeams allTeams : singleBestTeams){
                    final String sql = "INSERT INTO singlegamesbasketball (Cpt, Util1, Util2, Util3, Util4, Util5, TotalSalary, TotalPoints, PlayerId, GamesPlayed," +
                            "GamesStarted, FieldGoalsMadePerGame, FieldGoalsAttemptedPerGame,ThreePointsAveragePerGame,ThreePointsAttemptedPerGame, TwoPointFieldGoalsPerGame," +
                            "TwoPointAverageAttemptedPerGame, FreeThrowsAveragePerGame, FreeThrowsAttemptedPerGame, AssistAveragePerGame, ReboundsAveragePerGame," +
                            "StealsAveragePerGame,BlocksAveragePerGame, TurnoversAveragePerGame, FoulsAveragePerGame, PointsAveragePerGame, MinutesAveragePerGame ) " +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement myStmt = connect.prepareStatement(sql);

                    myStmt.setString(1, allTeams.getCpt());
                    myStmt.setString(2, allTeams.getUtil1());
                    myStmt.setString(3, allTeams.getUtil2());
                    myStmt.setString(4, allTeams.getUtil3());
                    myStmt.setString(5, allTeams.getUtil4());
                    myStmt.setString(6, allTeams.getUtil5());
                    myStmt.setInt(7, allTeams.getSalary());
                    myStmt.setDouble(8, allTeams.getAverageFantasyPoints());
                    myStmt.setLong(9, allTeams.getPlayersId());
                    myStmt.setInt(10, allTeams.getGamesPlayed());
                    myStmt.setInt(11, allTeams.getGamesStarted());
                    myStmt.setDouble(12, allTeams.getFieldGoalsMadePerGame());
                    myStmt.setDouble(13, allTeams.getFieldGoalsAttemptedPerGame());
                    myStmt.setDouble(14, allTeams.getThreePointsAveragePerGame());
                    myStmt.setDouble(15, allTeams.getThreePointsAttemptedPerGame());
                    myStmt.setDouble(16, allTeams.getTwoPointFieldGoalsPerGame());
                    myStmt.setDouble(17, allTeams.getTwoPointAverageAttemptedPerGame());
                    myStmt.setDouble(18, allTeams.getFreeThrowsPerGame());
                    myStmt.setDouble(19, allTeams.getFreeThrowsAttemptedPerGame());
                    myStmt.setDouble(20, allTeams.getAssistPerGame());
                    myStmt.setDouble(21, allTeams.getReboundsPerGame());
                    myStmt.setDouble(22, allTeams.getStealsPerGame());
                    myStmt.setDouble(23, allTeams.getBlocksPerGame());
                    myStmt.setDouble(24, allTeams.getTurnoversPerGame());
                    myStmt.setDouble(25, allTeams.getFoulsPerGame());
                    myStmt.setDouble(26, allTeams.getPointsPerGame());
                    myStmt.setDouble(27, allTeams.getMinPerGame());
                    myStmt.executeUpdate();
                }
                System.out.println("All records added...");
                connect.close();
            }catch(SQLException e) {
                e.printStackTrace();
                e.getCause();
            }
        }else{
            System.out.println("There are no teams to add.");
        }
    }
    public void getAllPlayersFromDatabase(){
        //Connect to database
        Connection connect = sqlConnection.sqlConnection();

        // Query all final string
        final String sql = "SELECT * FROM singlegamesbasketball ORDER BY TotalPoints desc ";
        // prepared statement to retrieve all records
        try{
            System.out.println("Retrieving all records");
            Statement stmt = connect.createStatement();
            ResultSet myRs = stmt.executeQuery(sql);
            while(myRs.next()){
                //Display values
                System.out.println("TeamId " + myRs.getInt("TeamId"));
                System.out.println("Cpt " + myRs.getString("Cpt"));
                System.out.println("Util1 " + myRs.getString("Util1"));
                System.out.println("Util2 " + myRs.getString("Util2"));
                System.out.println("Util3 " + myRs.getString("Util3"));
                System.out.println("Util4 " + myRs.getString("Util4"));
                System.out.println("Util5 " + myRs.getString("Util5"));
                System.out.println("Total Salary " + myRs.getInt("TotalSalary"));
                System.out.println("Total Points " + myRs.getDouble("TotalPoints"));
                System.out.println();

            }
            System.out.println("All records retrieved");
            connect.close();
        }catch(SQLException e){
            System.out.println("Unable to execute select statement");
            e.getCause();
            e.printStackTrace();
        }
    }

    public void selectOnePlayer(String player1){
        //connect to database
        Connection connect = sqlConnection.sqlConnection();

        // Query all final string
        try{
            final String sql = "SELECT * FROM singlegamesbasketball WHERE Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR " +
                    " Util5 = ?";
            // prepared statement to execute sql statement
            PreparedStatement stmt = connect.prepareStatement(sql);
            // add parameters to sql statement
            stmt.setString(1, player1);
            stmt.setString(2, player1);
            stmt.setString(3, player1);
            stmt.setString(4, player1);
            stmt.setString(5, player1);
            stmt.setString(6, player1);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Retrieving all records");
                while(rs.next()){
                    //Display values
                    System.out.println("TeamId " + rs.getInt("TeamId"));
                    System.out.println("Cpt " + rs.getString("Cpt"));
                    System.out.println("Util1 " + rs.getString("Util1"));
                    System.out.println("Util2 " + rs.getString("Util2"));
                    System.out.println("Util3 " + rs.getString("Util3"));
                    System.out.println("Util4 " + rs.getString("Util4"));
                    System.out.println("Util5 " + rs.getString("Util5"));
                    System.out.println("Total Salary " + rs.getInt("TotalSalary"));
                    System.out.println("Total Points " + rs.getDouble("TotalPoints"));
                    System.out.println();

                }
                System.out.println("All records retrieved");
                connect.close();

        }catch(SQLException e){
            System.out.println("Unable to retrieve players from database");
            e.getCause();
            e.printStackTrace();
        }


    }

    public void selectTwoPlayers(String player1, String player2){
        //connect to database
        Connection connect = sqlConnection.sqlConnection();

        // Query all final string
        try{
            final String sql = "SELECT * FROM singlegamesbasketball WHERE (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR " +
                    " Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?)";
            // prepared statement to execute sql statement
            PreparedStatement stmt = connect.prepareStatement(sql);
            // add parameters to sql statement
            stmt.setString(1, player1);
            stmt.setString(2, player1);
            stmt.setString(3, player1);
            stmt.setString(4, player1);
            stmt.setString(5, player1);
            stmt.setString(6, player1);
            stmt.setString(7, player2);
            stmt.setString(8, player2);
            stmt.setString(9, player2);
            stmt.setString(10, player2);
            stmt.setString(11, player2);
            stmt.setString(12, player2);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Retrieving all records");
            while(rs.next()){
                //Display values
                System.out.println("TeamId " + rs.getInt("TeamId"));
                System.out.println("Cpt " + rs.getString("Cpt"));
                System.out.println("Util1 " + rs.getString("Util1"));
                System.out.println("Util2 " + rs.getString("Util2"));
                System.out.println("Util3 " + rs.getString("Util3"));
                System.out.println("Util4 " + rs.getString("Util4"));
                System.out.println("Util5 " + rs.getString("Util5"));
                System.out.println("Total Salary " + rs.getInt("TotalSalary"));
                System.out.println("Total Points " + rs.getDouble("TotalPoints"));
                System.out.println();

            }
            System.out.println("All records retrieved");
            connect.close();

        }catch(SQLException e){
            System.out.println("Unable to retrieve players from database");
            e.getCause();
            e.printStackTrace();
        }
    }

    public void selectThreePlayers(String player1, String player2, String player3){
        //connect to database
        Connection connect = sqlConnection.sqlConnection();

        // Query all final string
        try{
            final String sql = "SELECT * FROM singlegamesbasketball WHERE (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR " +
                    " Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?) AND (Cpt = ? OR Util1 = ? OR " +
                    "Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?)";
            // prepared statement to execute sql statement
            PreparedStatement stmt = connect.prepareStatement(sql);
            // add parameters to sql statement
            stmt.setString(1, player1);
            stmt.setString(2, player1);
            stmt.setString(3, player1);
            stmt.setString(4, player1);
            stmt.setString(5, player1);
            stmt.setString(6, player1);
            stmt.setString(7, player2);
            stmt.setString(8, player2);
            stmt.setString(9, player2);
            stmt.setString(10, player2);
            stmt.setString(11, player2);
            stmt.setString(12, player2);
            stmt.setString(13, player3);
            stmt.setString(14, player3);
            stmt.setString(15, player3);
            stmt.setString(16, player3);
            stmt.setString(17, player3);
            stmt.setString(18, player3);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Retrieving all records");
            while(rs.next()){
                //Display values
                System.out.println("TeamId " + rs.getInt("TeamId"));
                System.out.println("Cpt " + rs.getString("Cpt"));
                System.out.println("Util1 " + rs.getString("Util1"));
                System.out.println("Util2 " + rs.getString("Util2"));
                System.out.println("Util3 " + rs.getString("Util3"));
                System.out.println("Util4 " + rs.getString("Util4"));
                System.out.println("Util5 " + rs.getString("Util5"));
                System.out.println("Total Salary " + rs.getInt("TotalSalary"));
                System.out.println("Total Points " + rs.getDouble("TotalPoints"));
                System.out.println();

            }
            System.out.println("All records retrieved");
            connect.close();

        }catch(SQLException e){
            System.out.println("Unable to retrieve players from database");
            e.getCause();
            e.printStackTrace();
        }
    }
    public void selectFourPlayers(String player1, String player2, String player3,String player4){
    //connect to database
    Connection connect = sqlConnection.sqlConnection();

    // Query all final string
        try{
        final String sql = "SELECT * FROM singlegamesbasketball WHERE (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR " +
                " Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?) AND (Cpt = ? OR Util1 = ? OR " +
                "Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR " +
                "Util4 = ? OR Util5 = ?)";
        // prepared statement to execute sql statement
        PreparedStatement stmt = connect.prepareStatement(sql);
        // add parameters to sql statement
        stmt.setString(1, player1);
        stmt.setString(2, player1);
        stmt.setString(3, player1);
        stmt.setString(4, player1);
        stmt.setString(5, player1);
        stmt.setString(6, player1);
        stmt.setString(7, player2);
        stmt.setString(8, player2);
        stmt.setString(9, player2);
        stmt.setString(10, player2);
        stmt.setString(11, player2);
        stmt.setString(12, player2);
        stmt.setString(13, player3);
        stmt.setString(14, player3);
        stmt.setString(15, player3);
        stmt.setString(16, player3);
        stmt.setString(17, player3);
        stmt.setString(18, player3);
        stmt.setString(19, player4);
        stmt.setString(20, player4);
        stmt.setString(21, player4);
        stmt.setString(22, player4);
        stmt.setString(23, player4);
        stmt.setString(24, player4);

        ResultSet rs = stmt.executeQuery();
        System.out.println("Retrieving all records");
        while(rs.next()){
            //Display values
            System.out.println("TeamId " + rs.getInt("TeamId"));
            System.out.println("Cpt " + rs.getString("Cpt"));
            System.out.println("Util1 " + rs.getString("Util1"));
            System.out.println("Util2 " + rs.getString("Util2"));
            System.out.println("Util3 " + rs.getString("Util3"));
            System.out.println("Util4 " + rs.getString("Util4"));
            System.out.println("Util5 " + rs.getString("Util5"));
            System.out.println("Total Salary " + rs.getInt("TotalSalary"));
            System.out.println("Total Points " + rs.getDouble("TotalPoints"));
            System.out.println();

        }
        System.out.println("All records retrieved");
        connect.close();

    }catch(SQLException e){
        System.out.println("Unable to retrieve players from database");
        e.getCause();
        e.printStackTrace();
    }
}

    public void selectFivePlayers(String player1, String player2, String player3, String player4, String player5){
        //connect to database
        Connection connect = sqlConnection.sqlConnection();

        // Query all final string
        try{
            final String sql = "SELECT * FROM singlegamesbasketball WHERE (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR " +
                    " Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?) AND (Cpt = ? OR Util1 = ? OR " +
                    "Util2 = ? OR Util3 = ? OR Util4 = ? OR  Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR " +
                    "Util4 = ? OR Util5 = ?) AND (Cpt = ? OR Util1 = ? OR Util2 = ? OR Util3 = ? OR Util4 = ? OR Util5 = ?)";
            // prepared statement to execute sql statement
            PreparedStatement stmt = connect.prepareStatement(sql);
            // add parameters to sql statement
            stmt.setString(1, player1);
            stmt.setString(2, player1);
            stmt.setString(3, player1);
            stmt.setString(4, player1);
            stmt.setString(5, player1);
            stmt.setString(6, player1);
            stmt.setString(7, player2);
            stmt.setString(8, player2);
            stmt.setString(9, player2);
            stmt.setString(10, player2);
            stmt.setString(11, player2);
            stmt.setString(12, player2);
            stmt.setString(13, player3);
            stmt.setString(14, player3);
            stmt.setString(15, player3);
            stmt.setString(16, player3);
            stmt.setString(17, player3);
            stmt.setString(18, player3);
            stmt.setString(19, player4);
            stmt.setString(20, player4);
            stmt.setString(21, player4);
            stmt.setString(22, player4);
            stmt.setString(23, player4);
            stmt.setString(24, player4);
            stmt.setString(25, player5);
            stmt.setString(26, player5);
            stmt.setString(27, player5);
            stmt.setString(28, player5);
            stmt.setString(29, player5);
            stmt.setString(30, player5);


            ResultSet rs = stmt.executeQuery();
            System.out.println("Retrieving all records");
            while(rs.next()){
                //Display values
                System.out.println("TeamId " + rs.getInt("TeamId"));
                System.out.println("Cpt " + rs.getString("Cpt"));
                System.out.println("Util1 " + rs.getString("Util1"));
                System.out.println("Util2 " + rs.getString("Util2"));
                System.out.println("Util3 " + rs.getString("Util3"));
                System.out.println("Util4 " + rs.getString("Util4"));
                System.out.println("Util5 " + rs.getString("Util5"));
                System.out.println("Total Salary " + rs.getInt("TotalSalary"));
                System.out.println("Total Points " + rs.getDouble("TotalPoints"));
                System.out.println();

            }
            System.out.println("All records retrieved");
            connect.close();

        }catch(SQLException e){
            System.out.println("Unable to retrieve players from database");
            e.getCause();
            e.printStackTrace();
        }
    }
}
