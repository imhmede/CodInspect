package Upload_here;

import java.util.Scanner;

/**
 * This program receives two parameters describing a card rank and a card suit and returns the description
 * while also indicating an invalid format or rank if entered.
 * @author Jessica Provencio
 */
public class CardDescription {

    /**
     * Converts shorthand card notation into a full card description.
     * @param rank the rank of the card 
     * @param suit the suit of the card 
     * @return full description or an invalid message
     */
    public static String getCardDescription(String rank, String suit) {
        String fullRank = "";
        String fullSuit = "";

        switch (rank) {
            case "A": fullRank = "Ace"; break;
            case "J": fullRank = "Jack"; break;
            case "Q": fullRank = "Queen"; break;
            case "K": fullRank = "King"; break;
            default:
                if (rank.matches("[2-9]|10")) {
                    fullRank = rank;
                } else {
                    return "Invalid rank: " + rank;
                }
        }

        switch (suit) {
            case "D": fullSuit = "Diamonds"; break;
            case "H": fullSuit = "Hearts"; break;
            case "S": fullSuit = "Spades"; break;
            case "C": fullSuit = "Clubs"; break;
            default: return "Invalid suit: " + suit;
        }

        return fullRank + " of " + fullSuit;
    }

     /**
     * This is the main method.
     * @param args command-line arguments 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card notation (ex. AC for Ace of Clubs): ");
        String input = scanner.next().toUpperCase();
        String rank, suit;

        if (input.length() == 2) {
            rank = input.substring(0, 1);
            suit = input.substring(1, 2);
        } else if (input.length() == 3 && input.startsWith("10")) {
            rank = "10";
            suit = input.substring(2);
        } else {
            System.out.println("Invalid input format.");
            scanner.close();
            return;
        }

        String description = getCardDescription(rank, suit);
        System.out.println(description);

        scanner.close();
    }
}
