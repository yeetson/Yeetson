//  BlackJack.java
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import static java.lang.System.in;

public class blackjack {
  
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(in);	//creates Scanner
	    Random myRandom = new Random();			//random card generator
	    ArrayList <Integer> numlist = new ArrayList <Integer>();
	    ArrayList <Integer> playlist = new ArrayList <Integer>();
	   
	    int[] player_num = {1, 2, 3};  //Arraylist of how many players
		int num_of_aces = 0;           // int for value of an Ace
		int points = 0;                // int for number of points
		String name_of_card=" ";       // int for card name call out in case structure
		char winner='N';              // int for wanting to stay
		char play_again = 'Y';        // int for hitting 
		int Playercard;				//int for what the card is
		int totalPlayer_points;		//int for total points
	    int maxSoFar= 0;			//int for max amount so far
	    int maxPlayer = 0;			//int for number of players
	    int sum_total = 0;
	    int max=0;
		int maxlistno= 0;

		for (int i : player_num)	//enhanced forloop for player
		{
			System.out.println("Would you like to play BlackJack Y/N, Player " + i+ "?");
			play_again = myScanner.findWithinHorizon(".",0).charAt(0);   //method for choosing Y/N
			play_again = Character.toUpperCase(play_again); 	       //uppercase
			totalPlayer_points = 0;
			if (play_again == 'N')
			{
				System.out.println("ok, that works too.");
			}
				while (play_again == 'Y')
				{				
				Playercard = myRandom.nextInt(13) + 1;   //number of cases in structure
			                                             		
			    switch (Playercard)
			    {
			    case 1:
			    	name_of_card = "Ace";
			    	num_of_aces = +1;
			    	points = 11;
			    	break;
			    case 2:
			    	name_of_card = "Two";
			    	points = 2;
			    	break;
			    case 3:
			    	name_of_card = "Three";
			    	points = 3;
			    	break;
			    case 4:
			    	name_of_card = "Four";
			    	points = 4;
			    	break;
			    case 5:
			    	name_of_card = "Five";
			    	points = 5;
			    	break;
			    case 6:
			    	name_of_card = "Six";
			    	points = 6;
			    	break;
			    case 7:
			    	name_of_card = "Seven";
			    	points = 7;
			    	break;
			    case 8:
			    	name_of_card = "Eight";
			    	points = 8;
			    	break;
			    case 9:
			    	name_of_card = "Nine";
			    	points = 9;
			    	break;
			    case 10:
			    	name_of_card = "Ten";
			    	points = 10;
			    	break;
			    case 11:
			    	name_of_card = "Jack";
			    	points = 10;
			    	break;
			    case 12:
			    	name_of_card = "Queen";
			    	points = 10;
			    	break;
			    case 13:
			    	name_of_card = "King";
			    	points = 10;
			    	break;
			    }
			   totalPlayer_points += points; //adds total amount of points
			    
			    System.out.println("You drew a/an " + name_of_card);	    
			    
			    Calc_Total c;			    
			    c = new Calc_Total(totalPlayer_points,0);		//consturctor that adds sum
			   
			    int total_pts = c.sum();
			    
			    //When player has gone over 21 but has an Ace subtract 10 points
			    while (total_pts > 21 && num_of_aces >= 1)
			    {
			    	total_pts = total_pts - 10;			//if ace goes over 21 it subtracts 10
			    	num_of_aces = num_of_aces - 1;
			    	if (total_pts == 21)
			    	{
			    		System.out.println();		//if 21 is got u win
			    		System.out.println();
			    		System.out.println("You have 21!!");
			    		System.out.println("You are the WINNER!!");
			    		winner = 'Y';
			    		play_again = 'N';
			    	}
			      
			    }  //end of	 while (totalPlayer_points > 21 && num_of_aces >= 1)
			    
		    System.out.println("You have " + total_pts + " total points");
			  
		    //
		    if (play_again == 'Y'  && winner == 'N' && total_pts <= 21)  
			   {
		       System.out.println();
			   System.out.println("Player " + i + " Hit (Y) or Stay (N)?");  
			   play_again = myScanner.findWithinHorizon(".",0).charAt(0);   //same method of Y/N
			   play_again = Character.toUpperCase(play_again); 	  
			   }
		    if (total_pts > 21)
	    	{
		    	System.out.println(); 		//player gets emilated after 21
	    		System.out.println("You busted!!  You are over 21 points!");
	    		winner = 'N';
	    		play_again = 'N';
	       	}  
		    if (total_pts == 21)
	    	{
		    	System.out.println(); //if u get 21 u win
	    		System.out.println("You are the winner with 21 points!");
	    		winner = 'Y';
	    		play_again = 'N';
	    		
	    	} 
		      
		   	   numlist.add(total_pts); 		//add total points
		   	   playlist.add(i);
			     
	       } //end of while (play_again == 'Y'  && winner == 'N')
				
				
		   }  // end of while (play_again == 'Y')
		
		 
		System.out.println();
		System.out.println();
	
		
		
		for (int j= 0; j<numlist.size(); j++)
		{
		   int number = numlist.get(j);			//gets the number of the player that wins
		   
		   if(number > max && number <22)
		   {
		      max = number;
		      maxlistno = j;
		      
		    }
		}
		    System.out.println(" with a total of " + max + " you win!");
		   
		  
	}// end of for loop
	
	
}  //end of main loop