package Upload_here;

import java.util.Scanner;

/**
 * This program will accept card description notation and return the full name of the rank and suit
 * @author Sam Hodges
 * @date 2025-03-24 
 */
public class CardDescription {

     /**
     * This method accepts two arguments and returns a verbose description of the card rank and suit
     * @param rank a string depicting card rank
     * @param suit a string depicting one of the four card suits
     */
    public static String getCardDescription(String rank, String suit) {
        String description;
        String fullRank = "";
        String fullSuit = "";
        
        if(rank.equals("A")){
            fullRank = "Ace";
        }else if(rank.equals("K")){
            fullRank = "King";
        }else if(rank.equals("Q")){
            fullRank = "Queen";
        }else if(rank.equals("J")){
            fullRank = "Jack";
        }else if(rank.equals("1")){
            fullRank = "1";
        }else if(rank.equals("2")){
            fullRank = "2";
        }else if(rank.equals("3")){
            fullRank = "3";
        }else if(rank.equals("4")){
            fullRank = "4";
        }else if(rank.equals("5")){
            fullRank = "5";
        }else if(rank.equals("6")){
            fullRank = "6";
        }else if(rank.equals("7")){
            fullRank = "7";
        }else if(rank.equals("8")){
            fullRank = "8";
        }else if(rank.equals("9")){
            fullRank = "9";
        }else if(rank.equals("10")){
            fullRank = "10";            
        }

        if(suit.equals("H")){
            fullSuit = "Hearts";
        }else if(suit.equals("D")){
            fullSuit = "Diamonds";            
        }else if(suit.equals("C")){
            fullSuit = "Clubs";       
        }else if(suit.equals("S")){
            fullSuit = "Spades";     
        }

        //concatenate the rank and suit and make them pretty
        description = fullRank + " of " + fullSuit;
        return description; 
    }


    /**
     * This is the main method
     * @param args a list of possible arguments passed by the user
    */
    public static void main(String[] args) { 
        String suit = "";
        String rank = "";
        String suitContents = "SHCD";  //the four valid suits
        String rankContents ="AKQJ12345678910";  //the valid card ranks
        String description = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the one character card suit (S for spades, H for hearts, C for clubs, D for diamonds): ");
        suit = scanner.nextLine();

        // here is some error checking to ensure I get an expected value for the card suit
        if(!suitContents.contains(suit)){
            System.out.println("Entry error - please only enter the one character card suit (S for spades, H for hearts, C for clubs, D for diamonds.");
            scanner.close();
            System.exit(0);
        }else{
        
            System.out.print("Enter the one character rank (A, K, Q, J, 2-10 for numeric cards): ");
            rank = scanner.nextLine();

            // here is some error checking to ensure I get an expected value for the card rank
            if(!rankContents.contains(rank)){
                System.out.println("Entry error - please only enter the one character rank (A, K, Q, J, 2-10 for numeric cards).");
                scanner.close();
                System.exit(0);
            }
        }
        scanner.close();

        description = getCardDescription(rank, suit);
        System.out.println(description);
    
    }
 
}

