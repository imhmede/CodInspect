/**
 * @author Essa Imhmed
 */

public class CardDescription {
    
        public static String getCardDescription(String rank, String suit) {
            String rankDescription = "";
            String suitDescription = "";
            if (rank.equals("A")) {
                rankDescription = "Ace";
            } else if (rank.equals("2")||(rank.equals("3") || rank.equals("4") || rank.equals("5") || rank.equals("6")
                    || rank.equals("7") || rank.equals("8") || rank.equals("9") || rank.equals("10"))) {
                rankDescription = rank; 
            } else if (rank.equals("J")) {
                rankDescription = "Jack";
            } else if (rank.equals("Q")) {
                rankDescription = "Queen";
            } else if (rank.equals("K")) {
                rankDescription = "King";
            } else {
                return "Invalid rank Valid ranks are A, 2-10, J, Q, K.";
            }
    
            if (suit.equals("D")) {
                suitDescription = "Diamonds";
            } else if (suit.equals("H")) {
                suitDescription = "Hearts";
            } else if (suit.equals("S")) {
                suitDescription = "Spades";
            } else if (suit.equals("C")) {
                suitDescription = "Clubs";
            } else {
                return "Invalid suit Valid suits are D, H, S, C.";
            }
    
            
            return rankDescription + " of " + suitDescription;
        }
    
        public static void main(String[] args) {
            System.out.println(getCardDescription("Q", "S"));
            System.out.println(getCardDescription("A", "D"));
            System.out.println(getCardDescription("10", "H"));
            System.out.println(getCardDescription("J", "C"));
            System.out.println(getCardDescription("K", "S")); 
    
            System.out.println(getCardDescription("Z", "S")); 
            System.out.println(getCardDescription("Q", "X"));
            System.out.println(getCardDescription("11", "D"));
            System.out.println(getCardDescription("A", "Z"));
        }
    }