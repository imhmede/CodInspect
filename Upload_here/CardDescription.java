/** This program converts shorthand card notation into a full description.
 * @author Essa Imhmed
 * @version 1.1
 * @date 2025-03-27
 * CS 123 Programming Assignment 05
*/

import java.util.Scanner;

/**
* This method takes the ranks and suits, returning the full card names.
* @param rank the card rank
* @param suit the card suit
* @return the full card description
*/

public class CardDescription {
    public static String getCardDescription(String rank, String suit) {
        String rankDescr = switch (rank) { // Single values perfect for switch
            case "A" -> "Ace";
            case "J" -> "Jack";
            case "Q" -> "Queen";
            case "K" -> "King";
            case "2", "3", "4", "5", "6", "7", "8", "9", "10" -> rank;
            // Numbers don't require conversion
            default -> "Invalid"; // Captures all invalid inputs
        };
    
        String suitDescr = switch (suit) {
            case "D" -> "Diamonds";
            case "H" -> "Hearts";
            case "S" -> "Spades";
            case "C" -> "Clubs";
            default -> "Invalid"; // Captures all invalid inputs
        };
    
        /**
         *  Base case: If any card input is invalid, 
            return "Sorry, that's an invalid card."
            else return full description of the card
         */

        if (rankDescr.startsWith("Invalid") ||
            suitDescr.startsWith("Invalid")) {
            return "Sorry, that's an invalid card.";
        // The smallest input already being used for method, no other calls
        }
        return rankDescr + " of " + suitDescr;
    }

    /**
    * The main method to collect the input content from the user.
    * @param args command-line arguments
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Ready for scanning
        System.out.print("Please input your card notation: "); 
        String input = scanner.next();
        String rank;
        String suit;
    
        // Splitting input before passing as an argument to getCardDescription
        if (input.length() == 2) {  // Single-digit ranks
            rank = input.substring(0, 1);  // E.g., "Q"
            suit = input.substring(1, 2);  // "S"
        } else if (input.length() == 3 && input.startsWith("10")) {  // "10" rank
            rank = input.substring(0, 2);  // E.g., "10"
            suit = input.substring(2, 3);  // "S"
        } else {
            rank = "";  // Invalid lengths to split
            suit = "";
        }
    
        String result = getCardDescription(rank, suit);
        System.out.println(result);  // E.g., "Queen of Spades"
    }
}
