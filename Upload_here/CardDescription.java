/**
 * Author: Essa Imhmed
 * Date: 03/25/2025
 * Program: CardDescription
 * This program converts card shorthand notation (e.g., "Q", "S") 
 *              into full card descriptions (e.g., "Queen of Spades").
 */

 public class CardDescription {

    /**
     * Converts rank and suit into full description of a card.
     * @param rank The shorthand card rank (e.g., "A", "2", ..., "10", "J", "Q", "K").
     * @param suit The shorthand card suit (e.g., "D", "H", "S", "C").
     * @return Full card description (e.g., "Queen of Spades") or error message for invalid input.
     */
    public static String getCardDescription(String rank, String suit) {
        String fullRank = "";
        String fullSuit = "";

        // Determine full rank
        if (rank.equals("A")) {
            fullRank = "Ace";
        } else if (rank.equals("J")) {
            fullRank = "Jack";
        } else if (rank.equals("Q")) {
            fullRank = "Queen";
        } else if (rank.equals("K")) {
            fullRank = "King";
        } else if (rank.matches("[2-9]|10")) {
            fullRank = rank;
        } else {
            return "Invalid card rank!";
        }

        // Determine full suit
        if (suit.equals("D")) {
            fullSuit = "Diamonds";
        } else if (suit.equals("H")) {
            fullSuit = "Hearts";
        } else if (suit.equals("S")) {
            fullSuit = "Spades";
        } else if (suit.equals("C")) {
            fullSuit = "Clubs";
        } else {
            return "Invalid card suit!";
        }

        return fullRank + " of " + fullSuit;
    }

    /**
     * Main method to test getCardDescription with various inputs.
     */
    public static void main(String[] args) {
        // Valid test cases
        System.out.println(getCardDescription("Q", "S"));  // Queen of Spades
        System.out.println(getCardDescription("10", "D")); // 10 of Diamonds
        System.out.println(getCardDescription("A", "H"));  // Ace of Hearts
        System.out.println(getCardDescription("7", "C"));  // 7 of Clubs

        // Invalid test cases
        System.out.println(getCardDescription("Z", "S"));  // Invalid card rank!
        System.out.println(getCardDescription("5", "X"));  // Invalid card suit!
    }
}