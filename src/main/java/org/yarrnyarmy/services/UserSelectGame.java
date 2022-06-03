package org.yarrnyarmy.services;

import org.yarrnyarmy.doa.SingleGameDatabase;

import java.util.Scanner;

public class UserSelectGame {
SingleGameDatabase sgd = new SingleGameDatabase();
    public void selectGamePlayer(){
        Scanner scan = new Scanner (System.in);
        Scanner scan2 = new Scanner (System.in);
        int userInput;

            System.out.println("Are you added data to the database? Press 1 if yes and 2 if no");
            userInput = scan.nextInt();
               if(userInput == 1){
                sgd.addToDatabase();
        }
        else if(userInput == 2){
                   System.out.println("Press 1 to retrieve all combinations from database.");
                   System.out.println("Press 2 to retrieve combinations with certain players");
                   int userCombination = scan.nextInt();
                   if(userCombination == 1){
                       sgd.getAllPlayersFromDatabase();
                   }
                   if(userCombination == 2){
                       System.out.println("How many players do you want to search with all combinations");
                       int playerSearch = scan.nextInt();
                       if(playerSearch == 1){
                           System.out.println("Enter player's name");
                           String playerName = scan2.nextLine();
                           sgd.selectOnePlayer(playerName);
                       }
                       if(playerSearch == 2){
                           Scanner scan3 = new Scanner(System.in);
                           Scanner scan4 = new Scanner(System.in);
                           System.out.println("Enter first player's name");
                           String player1 = scan3.nextLine();
                           System.out.println("Enter second player's name");
                           String player2 = scan4.nextLine();
                           sgd.selectTwoPlayers(player1, player2);
                       }

                       if(playerSearch == 3){
                           Scanner scan3 = new Scanner(System.in);
                           Scanner scan4 = new Scanner(System.in);
                           System.out.println("Enter first player's name");
                           String player1 = scan3.nextLine();
                           System.out.println("Enter second player's name");
                           String player2 = scan4.nextLine();
                           System.out.println("Enter third player's name");
                           String player3 = scan4.nextLine();
                           sgd.selectThreePlayers(player1, player2, player3);
                       }
                       if(playerSearch == 4){
                           Scanner scan3 = new Scanner(System.in);
                           Scanner scan4 = new Scanner(System.in);
                           System.out.println("Enter first player's name");
                           String player1 = scan3.nextLine();
                           System.out.println("Enter second player's name");
                           String player2 = scan4.nextLine();
                           System.out.println("Enter third player's name");
                           String player3 = scan4.nextLine();
                           System.out.println("Enter fourth player's name");
                           String player4 = scan4.nextLine();
                           sgd.selectFourPlayers(player1, player2, player3, player4);
                       }
                       if(playerSearch == 5){
                           Scanner scan4 = new Scanner(System.in);
                           System.out.println("Enter first player's name");
                           String player1 = scan4.nextLine();
                           System.out.println("Enter second player's name");
                           String player2 = scan4.nextLine();
                           System.out.println("Enter third player's name");
                           String player3 = scan4.nextLine();
                           System.out.println("Enter fourth player's name");
                           String player4 = scan4.nextLine();
                           System.out.println("Enter fifth player's name");
                           String player5 = scan4.nextLine();
                           sgd.selectFivePlayers(player1, player2, player3, player4, player5);
                       }
                   }
            }
        else{
                   System.out.println("Invalid entry");
               }

    }
}
