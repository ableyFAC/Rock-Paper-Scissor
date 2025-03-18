/******************************************************************************
things to possibly improve on:
 - a timer tool
 - pvp if it's even possible
 - naming the numbers

*******************************************************************************/

import java.util.Scanner;

public class RockPaperScissors
{
    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSORS = 3;

    static int BOT_SCORE = 0;
    static int PLAYER_SCORE = 0;
    
	public static void main(String[] args) 
	{
	    
	    Scanner in = new Scanner (System.in);
	    String proceed = "";
	   
	    intro();
	    
	    do
	    {
	        int choice = decision();
		    int botDecision = bot();
		   
		    if(choice != ROCK && choice != PAPER && choice != SCISSORS)
		    {
		        System.out.println("Hey! That's not an option >:(");
		    }
		    else
		    {
		        countDown();
		    
		        System.out.println("Your choice was " + choice);
		        System.out.println("The bot chose " + botDecision);
                System.out.println();
		    
		        winnerOrLoser(choice,botDecision);
		    }
		  
		    System.out.println();
		    System.out.println("Do you want to keep playing?(y/n): ");
		    proceed = in.next();
		    
	    }while(proceed.equals("y"));
		    System.out.println();
		    System.out.println("Thanks for playing my first coding project!");
	}
	
	public static void intro()
	{
	    System.out.print("Welcome to the classic game of ");
		System.out.println("Rock Paper Scissors!");
		
		System.out.print("You will be playing against a bot. Good Luck!");
		//System.out.println("and it will be best out of 3.");
		System.out.println();
	}
	
	public static int decision()
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Choose a number to play a hand");
        System.out.println("    1 for rock");
        System.out.println("    2 for paper");
        System.out.println("    3 for scissors");
        
        int choice = in.nextInt();
        
        System.out.println();
        return choice;
    }
    
    public static void countDown()
    {
        System.out.println("Let's test your luck...");
        System.out.println("Rock!");
        System.out.println("Paper!");
        System.out.println("Scissors!");
        System.out.println();
    }
    
    public static int bot()
    {
        double calculations = (Math.random() * (3 -1)) + 1;
        int botDecision = (int) calculations;
        return botDecision;
    }
    
    public static void winnerOrLoser(int choice, int botDecision) 
    {
        if ((choice == ROCK && botDecision == SCISSORS) || 
                (choice == PAPER && botDecision == ROCK) || 
                    (choice == SCISSORS && botDecision == PAPER)) 
        {
            System.out.println("Look at that! You won!");
            PLAYER_SCORE++;
        }
        else if ((choice == ROCK && botDecision == PAPER) || 
                    (choice == PAPER && botDecision == SCISSORS) || 
                        (choice == SCISSORS && botDecision == ROCK)) 
        {
            System.out.println("Aw man, you lost :(");
            BOT_SCORE++;
        }
        else 
        {
            System.out.println("Oh, you guys tied.  Didn't expect that...");
        }

        System.out.println("Your score is " + PLAYER_SCORE);
        System.out.println("The bot's score is " + BOT_SCORE);
    }
}
