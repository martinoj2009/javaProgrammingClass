//package tictactoe;

import java.util.*;

class TicTacToe
{
    char ttt[][] = new char[3][3];
    static final char player1 = 'O';
    static final char player2 = 'X';
    Scanner scan  =new Scanner(System.in);
    
        
    String playerID(char player)
    {
    // Prints the identity of the player
    // For example:
    // player2: X
    
        if (player == player1)
            return "player1: "+player;
        else
            return "player2: "+ player;
    }
    
    void getPlayerInput(char player)
    {
    // ******* Details to fill in ************
    
       // Prompt the user for a cell input.  Make sure its a legal
       // cell designator.  Also make sure the cell doesn't already
       // have a player in it.  Prompt the user again in the case 
       // of any problem.  Once a valid spot has been found, 
       // you will issue a statement like:
       
         ttt[row][col]=player;
            
    }
   
    boolean gameIsDraw()
    {
		return false;
     // ******* Details to fill in ************
     
        // If all ttt entries have been taken return true
        // otherwise return false
    }
    
    boolean winner(char player)
    {
		return false;
     // ******* Details to fill in ************
     
     // Check to see if the parameter player has won
     // Winning means that player shows up in a line of 
     // three.  The line can be a column, row or a diagonal
     // Return true if player is a winner, otherwise return false.
    }

    void displayBoard1()
    {
     // ******* Details to fill in ************
        
     // If you want to skip the fun of this, I have a candidate displayBoard down below
        
    }
    
     
    void newgame()
    {
        char currPlayer = player1;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                ttt[i][j] =' ';
        
        boolean continueFlag = true;        
        while (continueFlag)
        {
            displayBoard1();
            if (gameIsDraw())
            {
                System.out.println("Game Ends in Draw");
                continueFlag = false;
            }
            else
            {
                getPlayerInput(currPlayer);
                if (winner(currPlayer))
                {
                    System.out.println("We have a winner: " + playerID(currPlayer));
                    displayBoard1();
                    continueFlag = false;
                }
                else
                { 
                    if (currPlayer == player1) currPlayer = player2;
                        else currPlayer = player1;
                }
             }
        }
        
    }

    
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        String str;
        do
        {
            game.newgame();
            
            System.out.println("Do you want to play Tic-Tac-Toe (y/n)?");
            str= game.scan.next();
        } while ("y".equals(str));
        
        System.out.println("Bye");
    }    




void displayBoard()
    {
        System.out.println("********************************");        
        System.out.println("      ---a------b------c---");

        for (int i=0; i<3; i++)
        {
            for (int j=0; j< 3; j++)
            {
              if (j == 0) System.out.print("      |  "); 
              System.out.print(ttt[i][j]);
              if (j < 2) System.out.print( "   |  ");
              if (j==2)  System.out.print("  |");
            }
            System.out.println();
            switch (i)
            {
            case 0:
                System.out.println("      ---d------e------f---");
                break;
            case 1:
                System.out.println("      ---g------h------i---");
                break;
            case 2:
                System.out.println("      ---------------------");
                break;
            }
        }
    }
}
    
