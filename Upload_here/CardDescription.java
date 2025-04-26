import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author Essa Imhmed
 */
public class CardDescription {

    public static String getCardDescription(String rank, String suit) {
        // Mapping ranks to their full names
        Map<String, String> rankMap = new HashMap<>();
        rankMap.put("A", "Ace");
        rankMap.put("2", "2");
        rankMap.put("3", "3");
        rankMap.put("4", "4");
        rankMap.put("5", "5");
        rankMap.put("6", "6");
        rankMap.put("7", "7");
        rankMap.put("8", "8");
        rankMap.put("9", "9");
        rankMap.put("10", "10");
        rankMap.put("J", "Jack");
        rankMap.put("Q", "Queen");
        rankMap.put("K", "King");

        // Mapping suits to their full names
        Map<String, String> suitMap = new HashMap<>();
        suitMap.put("D", "Diamonds");
        suitMap.put("H", "Hearts");
        suitMap.put("S", "Spades");
        suitMap.put("C", "Clubs");

        // Validating input
        if (!rankMap.containsKey(rank) || !suitMap.containsKey(suit)) {
            return "Invalid card notation";
        }

        return rankMap.get(rank) + " of " + suitMap.get(suit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Testing multiple inputs
        String[][] testCases = {
                {"A", "S"}, // Ace of Spades
                {"10", "H"}, // 10 of Hearts
                {"K", "D"}, // King of Diamonds
                {"Q", "C"}, // Queen of Clubs
                {"5", "X"}, // Invalid card notation
                {"Z", "S"}  // Invalid card notation
        };

        for (String[] testCase : testCases) {
            System.out.println("Input: " + testCase[0] + testCase[1] + " -> " + getCardDescription(testCase[0], testCase[1]));
        }

        // Allow user input
        System.out.println("Enter a card rank (e.g., A, 2-10, J, Q, K): ");
        String userRank = scanner.next().toUpperCase();
        System.out.println("Enter a card suit (D, H, S, C): ");
        String userSuit = scanner.next().toUpperCase();

        System.out.println("Result: " + getCardDescription(userRank, userSuit));

        scanner.close();
    }
}