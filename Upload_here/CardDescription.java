package Upload_here;

import java.util.Scanner;

/**
 * This program gives a card description based on shorthand notation.
 * Example: QS is Queen of Spades
 * @author Angel Uriel Garcia Vega 
 * @date March 26th 2025
 */
public class CardDescription {

    /**
     * Main Method collects user input 
     * @param args command line arguments 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter card notation (Exp: QS for Queen of Spades): ");
        String inputCardNotation = scanner.next().toUpperCase(); // change input to uppercase for case sensitivity

        // check that input length is 2 characters no more no less
        if (inputCardNotation.length() < 2 || inputCardNotation.length() > 3) {
            System.out.println("INVALID INPUT! Please try again using valid notation like QS, 10H, etc.");
        } else {
            
            // Separate rank and suit, isolate rank and isolate suit to find what they are 
            String rank = inputCardNotation.substring(0, inputCardNotation.length() - 1);
            String suit = inputCardNotation.substring(inputCardNotation.length() - 1);

            // Get card description
            String description = getCardDescription(rank, suit);
            if (description != null) { // if one of the descriptions does not match null and print invalid card notation 
                
                System.out.println("Card Description: " + description);

            } else {
                
                System.out.println("INVALID CARD NOTATION");
            }
        }
        scanner.close(); // Close scanner to prevent leaks
    }

    /**
     * Converts short notation to a full card description.
     * @param rank the rank of the card (A, 2 to 10, J, Q, K)
     * @param suit the suit of the card (Diamonds, Hearts, Spades, Clubs)
     * @return the full description of the card or null if invalid
     */
    public static String getCardDescription(String rank, String suit) {
        String rankDescription;
        String suitDescription;

        // Convert rank notation to full name, switch out letter for full description 
        switch (rank) {
            case "A":
                rankDescription = "Ace";
                break;
            case "J":
                rankDescription = "Jack";
                break;
            case "Q":
                rankDescription = "Queen";
                break;
            case "K":
                rankDescription = "King";
                break;
            case "2": case "3": case "4": case "5":
            case "6": case "7": case "8": case "9": case "10":
                rankDescription = rank;
                break;
            default:
                return null; // Invalid rank
        }

        // Convert suit notation to full name, switch out letter for full description 
        switch (suit) {
            case "D":
                suitDescription = "Diamonds";
                break;
            case "H":
                suitDescription = "Hearts";
                break;
            case "S":
                suitDescription = "Spades";
                break;
            case "C":
                suitDescription = "Clubs";
                break;
            default:
                return null; // Invalid suit
        }

        // Return full card description to the user
        return rankDescription + " of " + suitDescription;
    }
}
