/*
 * This program converts inputed short hand notation into the cards description
 * @Author Essa Imhmed
 * Date: 3/27/25
 */
import java.util.Scanner;
public class CardDescription {
    /* Converts short hand notation into the cards description
    *  @param rank, The card's rank (A, Q, K, J, 2-10)
    *  @param suit, The card's suit (S, C, D, H)
    */ 
    public static String getCardDescription(String rank, String suit) {
    String rankDescription = "";
    String suitDescription = "";
    // Determines the Card's rank
    if (rank.equalsIgnoreCase("A")) {
        rankDescription = "Ace";
    } else if (rank.equalsIgnoreCase("Q")) {
        rankDescription = "Queen";
    } else if (rank.equalsIgnoreCase("K")) {
        rankDescription = "King";
    } else if (rank.equalsIgnoreCase("J")) {
        rankDescription = "Jack";
    } else if (Integer.parseInt(rank) >= 2 && Integer.parseInt(rank) <= 10) {
        rankDescription = rank;
    } else {
        rankDescription = "Invalid rank";
    }
    // Determines the Card's suit
    if (suit.equalsIgnoreCase("S")) {
        suitDescription = " of Spades";
    } else if (suit.equalsIgnoreCase("C")) {
        suitDescription = " of Clubs";
    } else if (suit.equalsIgnoreCase("D")) {
        suitDescription = " of Diamonds";
    } else if (suit.equalsIgnoreCase("H")) {
        suitDescription = " of Hearts";
    } else { 
        suitDescription = " of an Invalid suit";
    }
    // Concatenates the rank and suit into a full description of the card
    String fullDescription = rankDescription + suitDescription;
    return fullDescription;
    }
        /*
        * This is the main method
        * @param args a command line arguments
        */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cards rank: ");
        String rank = scanner.nextLine();
        System.out.print("Enter the cards suit: ");
        String suit = scanner.nextLine();
        scanner.close();
        getCardDescription(rank, suit);
    // Prints out the card description
        System.out.printf("The card is the %s", getCardDescription(rank, suit));
    }
}
