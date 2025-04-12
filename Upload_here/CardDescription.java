/**
 * This program takes the shorthand rank and suit of a card and returns the full name of the card.
 * The ranks are 2-10, J, Q, K, A and the suits are C, D, H, S.
 * The program uses recursion to repeatedly ask for valid input if the user provides invalid shorthand.
 * @author Essa Imhmed
 */

 import java.util.*;

 public class CardDescription {
 
     /**
      * This method takes the shorthand rank and suit of a card and returns the full name of the card.
      * Recursion is used to re-prompt the user for valid input when invalid input is detected.
      * @param rank the shorthand rank of the card
      * @param suit the shorthand suit of the card
      * @return the full name of the card
      */
     public static String getCardDescription(String rank, String suit) {
         String ranks = "2345678910JQKA";
         String suits = "CDHS";
         
         // Handle invalid inputs recursively
         int rankIndex = ranks.indexOf(rank);
         int suitIndex = suits.indexOf(suit);
         
         if (rankIndex == -1 || suitIndex == -1) {
             System.out.println("Invalid card. Please try again.");
             
             // Recursively call the main method to re-prompt the user
             main(null); 
             
             return "";
         }
         
         // Arrays to hold the full card names
         String[] rankNames = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                               "Ten", "Jack", "Queen", "King", "Ace"};
         String[] suitNames = {"Clubs", "Diamonds", "Hearts", "Spades"};
         
         return rankNames[rankIndex] + " of " + suitNames[suitIndex];
     }
 
     /**
      * This is the main method that handles input and prints the card description.
      * It uses recursion to re-prompt the user for an input if an invalid input is detected.
      * @param args
      */
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         
         System.out.println("Enter the shorthand rank of the card: ");
         String rank = in.nextLine().toUpperCase();
         
         System.out.println("Enter the shorthand suit of the card: ");
         String suit = in.nextLine().toUpperCase();
         
         // Display the card description or recursively re-prompt
         String result = getCardDescription(rank, suit);
         
         if (!result.isEmpty()) {
             System.out.println(result);
         }
         
         in.close();
     }
 }
 