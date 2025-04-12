import java.util.Scanner;
/**
 * This program finds two parameters: card rank and card suit.
 * @author Serenity Weddle
 * @date March 27, 2025
 */
public class CardDescription {
     public static String getCardDescription(String rank, String suit) {
        // Inital values
        String cardRank;
        String cardSuit;
        String cardName;

        // Possible input values for the card's rank.
        if(rank.equals("A"))
        {
            cardRank = "Ace";
        }
        else if(rank.equals("J"))
        {
            cardRank = "Jack";
        }
        else if(rank.equals("Q"))
        {
            cardRank = "Queen";
        }
        else if(rank.equals("K"))
        {
            cardRank = "King";
        }
        else if(rank.equals("2"))
        {
            cardRank = "2";
        }
        else if(rank.equals("3"))
        {
            cardRank = "3";
        }
        else if(rank.equals("4"))
        {
            cardRank = "4";
        }
        else if(rank.equals("5"))
        {
            cardRank = "5";
        }
        else if(rank.equals("6"))
        {
            cardRank = "6";
        }
        else if(rank.equals("7"))
        {
            cardRank = "7";
        }
        else if(rank.equals("8"))
        {
            cardRank = "8";
        }
        else if(rank.equals("9"))
        {
            cardRank = "9";
        }
        else if(rank.equals("10"))
        {
            cardRank = "10";
        }
        else {
            cardRank = "Invalid Input.";
        }

        // Possible input values for the card's suit.
        if(suit.equals("H"))
        {
              cardSuit = "Hearts";
        }
        else if(suit.equals("D"))
        {
              cardSuit = "Diamonds";
        }
        else if(suit.equals("S"))
        {
              cardSuit = "Spades";
        }
        else if(suit.equals("C"))
        {
              cardSuit = "Clubs";
        }
        else {
              cardSuit = "Invalid Input.";
        }

        cardName = "The card is the " + cardRank + " of " + cardSuit + "!a";
        
        // Returns values
        if(cardRank.equals("Invalid Input.")){
              return "Invalid Input.";
        }
        else if(cardSuit.equals("Invalid Input.")){
              return "Invalid Input.";
        }
        else {
              return cardName;
        }
     }

     // Receives the input.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the card's rank? (Use A, 2-10, J, Q or K.)");
        String rank = in.nextLine();
        System.out.println("What is the card's suit? (Use D, H, S or C.)");      
        String suit = in.nextLine();
        String cardName = getCardDescription(rank, suit);
        System.out.println(cardName);
        in.close();

    }
}
