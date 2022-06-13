

import java.util.*;
import java.io.*;


public class Battleship {
    
        public static void spacing() {
            for (int index = 0; index < 17; index++) {
            
            System.out.println("\n");
            }
        }
       public static int inputValidation(String input) {
        
        switch (input) {
            case "0":
                int coord1 = Integer.parseInt(input);
                return coord1;
                
                //break;
            case "1":
                int coord2 = Integer.parseInt(input);
                return coord2;
               // break;
            
            case "2":
                int coord3 = Integer.parseInt(input);
                return coord3;
                //break;
            case "3":
                int coord4 = Integer.parseInt(input);
                return coord4;
                //break;
            
            case "4":
                int coord5 = Integer.parseInt(input);
                return coord5;
                //break;
            default:
                
                return 5;

                
                //Reenter coordinate statement
                //function enterCoordinates method (is this recursive?)
        }
        
        
    }
    
    
public static char[][] enterCoordinates(String playerName, char[][] player) {
        
        System.out.printf("%s: ENTER YOUR SHIPS' COORDINATES 0-4 separated by a space. Ex: 0 4 \n",playerName);
        //Enter ship 1 location:
        for (int index = 1 ; index < 6; index++) {
            
                
                Scanner input = new Scanner(System.in);
                System.out.printf("Enter ship %d location:",index);
            
                String ship = input.nextLine();
                String arrayString[] = ship.split(" ");
                char arrayChar[] = ship.toCharArray(); 
                                                                                                         
                if (arrayString.length < 2) {
                    
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    index -= 1;
                    continue;
                } 
                String x =  arrayString[0];
                String y =  arrayString[1];
      
                int xcoord = inputValidation(x);
                int ycoord = inputValidation(y);
                if((xcoord > 4) || (ycoord > 4)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    index -= 1;
                    continue;
                    
                }else{
                    
                    if (player[xcoord][ycoord] == 
                    '@') {
                        
                    System.out.println("already have a ship here");
                    index -= 1;
                    continue;
                    
                    }
                    
                    else {
                        player[xcoord][ycoord] = '@';
                    }
                }
                
            
        }
        
        printBattleShip(player);
        spacing();
        return player;
        
    } 

public static int shipsLeft(String shooter,String target,char[][] board) {
    int shipCount = 0;
    for (char [] i : board) { 
        for (char j : i) {
            if (j == '@') {
                 shipCount += 1; 
            }
        // check each char in the row for @ using compare or eqquals or ==
        }
    }
    //System.out.printf("%s has %d ships left.\n",target,shipCount);
    return shipCount;
}

public static char[][][] turn(String player,String defendingPlayer, int pShips, char[][] pxLocation, char[][] pyTarget, int health) { 
            
            String uPlayer = player.toUpperCase();
            String uDefender = defendingPlayer.toUpperCase();
            /* The next few lines are how I originally tried to manage ending the game when one player's
            ships were all sunk. Casting did not work and newHealth would print in the terminal
            as a small cube which I did not understand. I copied the cube and googled it 
            and the search bar showed a question mark */
            
            /*health -= 5;
            System.out.println(health);
            char newHealth = (char)health;
            System.out.println(newHealth);*/
            
            //int hits = 0;
            /*if (player == "Player 1") {
                
                String defender = "Player 2";
                String uDefender = "PLAYER 2";
                
            } else {
                String defender = "Player 1";
                String uDefender = "PLAYER 1";
                
            }*/
            for (int index = 0 ; index < 1; index++) {
                Scanner shoot = new Scanner(System.in);
                System.out.printf("%s, enter hit row/column:", uPlayer);
            
                String target = shoot.nextLine();
                String arrayString[] = target.split(" ");
                char arrayChar[] = target.toCharArray(); 
                                                                                                         
                if (arrayString.length < 2) {
                    
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    index -= 1;
                    continue;
                } 
                String x =  arrayString[0];
                String y =  arrayString[1];
      
                int xcoord = inputValidation(x);
                int ycoord = inputValidation(y);
                if(xcoord > 4 || ycoord > 4) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    index -= 1;
                    continue;
                    
                } else {
                    
                    if (pxLocation[xcoord][ycoord] == '@') {
                    pxLocation[xcoord][ycoord] = 'X';
                    pyTarget[xcoord][ycoord] = 'X';
                    //health -= 1;
                    System.out.printf("%s HIT %s’s SHIP!\n",uPlayer,uDefender);
                    }
                    else if(pxLocation[xcoord][ycoord] == '-') { 
                        
                        pxLocation[xcoord][ycoord] = 'O';
                        pyTarget[xcoord][ycoord] = 'O';
                        System.out.printf("%s MISSED!\n",uPlayer);
                    }
                    else if (pxLocation[xcoord][ycoord] == 'O') {
                        
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        index -= 1;
                        continue;
                    }
                    else if (pxLocation[xcoord][ycoord] == 'X') {
                        
                        System.out.println("You already sunk the ship here");
                        index -= 1;
                        continue;
                        
                    }
                    
                    
                    }
                    
                    if (shipsLeft(player, defendingPlayer, pxLocation) == 0) {
                       // System.out.println("This is your new break statement");
                        break;
                    }
                }
               /* char convertHealth = (char)health;
                char[][] shipsSunk = {{convertHealth}};
                
                System.out.println(convertHealth);
                System.out.println(shipsSunk);
                System.out.println(rarray[2]); */
                char[][][] rarray = {pxLocation,pyTarget};
                printBattleShip(pyTarget);
               //System.out.printf("^^^^ Attackerboard\n");
               //printBattleShip(pxLocation);
               //System.out.println("^^^^ Locationboard");
                return rarray;
            }    
/*public static int health(char[][] locBoard,int life) {
    
    {{'4'}}
    
}*/

public static void main(String[] args) {
        
        System.out.println("Welcome to Battleship!\n");
        
        char[][] p1Location = {
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'} };
        
        char[][] p2Location = {
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'} };
                  
        char[][] p1Target = {
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'} };
        
        char[][] p2Target = {
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'},
                  {'-','-','-','-','-'} };
        
        char[][] Player1 = enterCoordinates("PLAYER 1",p1Location);
        //System.out.println(Arrays.toString(Player1[1]));
        //System.out.println("I am with Player1 ^");
        char[][] Player2 = enterCoordinates("PLAYER 2",p2Location);
        //System.out.println(Arrays.toString(Player2[1]));
        //System.out.println("I am with Player2 ^");
        int p1Ships = 5;
        int p2Ships = 5;
        /*char c = '9';
        String s = String.valueOf(c);
        int n2 = Integer.parseInt(s);
        int n = Integer.parseInt(String.valueOf(c)); */
        while (p1Ships >= 1 && p2Ships >= 1) {
            // A fight ensues 
            // add in the ++ into the if and else of the turn function
            char[][][] p1Turn= turn("Player 1","Player 2",p1Ships,p2Location,p1Target,p1Ships);
            p2Ships = shipsLeft("Player 2","Player 1", p2Location);
            if (p2Ships == 0) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
                break;
            }
            //System.out.printf("this is your number of ships left Player 2: %d",p2Ships);
            //System.out.println(p1Turn[2]);
            //System.out.println(p1Turn[2]);
            /*p1Ships = p1Ships -  Integer.parseInt(String.valueOf(p1Turn[2][0][0]));
            System.out.println(p1Ships); */
            
            //check sunk function here. make seperate array to pass in as parameter for the turn method for the Location boards
            //meant only for @ ships. use a count of @ to determine while loop. 
            System.out.printf("\nNew Turn\n");
            char[][][] p2Turn= turn("Player 2", "Player 1",p2Ships,p1Location,p2Target,p2Ships);
            p1Ships = shipsLeft("Player 1","Player 2", p1Location);
            if (p1Ships == 0) {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
            break;
        }/*else if (p2Ships == 0) {
            
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
            
        }*/
        
            
        }
        
        System.out.println("Final boards:");
        printBattleShip(p1Location);
        printBattleShip(p2Location);
        
    }//end of main
    
    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

}
