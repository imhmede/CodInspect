import java.util.Scanner;
/**
 * @author Essa Imhmed
 */

 // elliskooper
public class CardDescription {
    public static String getCardDescription(String rank, String suit) {
        String fullRank = switch (rank) {
            case "A" -> "Ace";
            case "J" -> "Jack";
            case "Q" -> "Queen";
            case "K" -> "King";
            case "2", "3", "4", "5", "6", "7", "8", "9", "10" -> rank;
            default -> null;
        };

        String fullSuit = switch (suit) {
            case "D" -> "Diamonds";
            case "H" -> "Hearts";
            case "S" -> "Spades";
            case "C" -> "Clubs";
            default -> null;
        };

        return (fullRank != null && fullSuit != null) ? fullRank + " of " + fullSuit : "Invalid card";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card rank: ");
        String rank = scanner.next().toUpperCase();
        System.out.print("Enter card suit: ");
        String suit = scanner.next().toUpperCase();
        System.out.println("Card description: " + getCardDescription(rank, suit));
        scanner.close();
    }
}