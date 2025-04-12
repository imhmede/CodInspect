import java.util.Scanner;

public class CardDescription {

    /**
     * Converts shorthand notation of a card to its full description.
     * @author Jerry Sena
     * @param rank The rank of the card (A, 2-10, J, Q, K).
     * @param suit The suit of the card ( D, H, S, C).
     * @return The full description of the card, or "Invalid input" if the input is incorrect.
     */
    
     public static String getCardDescription(String rank, String suit) {
        // Convert rank to full name
        String fullRank;
        switch (rank) {
            case "A": fullRank = "Ace"; break;
            case "J": fullRank = "Jack"; break;
            case "Q": fullRank = "Queen"; break;
            case "K": fullRank = "King"; break;
            case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "10":
                fullRank = rank; 
                break;
            default:
                return "Invalid input";
        }
        String fullSuit;
        switch (suit) {
            case "D": fullSuit = "Diamonds"; break;
            case "H": fullSuit = "Hearts"; break;
            case "S": fullSuit = "Spades"; break;
            case "C": fullSuit = "Clubs"; break;
            default:
                return "Invalid input";
        }
        return fullRank + " of " + fullSuit;
     }
     
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter card rank (A, 2-10, J, Q, K): ");
        String rank = scanner.next().toUpperCase();

        System.out.print("Enter card suit (D, H, S, C): ");
        String suit = scanner.next().toUpperCase();

        String description = getCardDescription(rank, suit);

        System.out.println("Card: " + description);

        scanner.close();

     }

}
