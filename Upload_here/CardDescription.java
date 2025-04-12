import java.util.Scanner;
/** 
 * This program will give you a card description based on 2 characters entered.
 * @author Lauren White
 * Date: 3/27/25
 * Assignment: CS 123, Assignment 5
 */
public class CardDescription {

    /**
     * This method will determine a card's description given a card rank and suit.
     * @param rank takes a card rank as a string.
     * @param suit takes a card suit as a string.
     * @return The card's description as a string.
     */
    public static String getCardDescription(String rank, String suit) {
        // Determines different card suits
        if (suit.equals("D")) {
            //Determines rank and returns description
            switch (rank) {
                case "2":
                    return "Two of Diamonds";
                case "3":
                    return "Three of Diamonds";
                case "4":
                    return "Four of Diamonds";
                case "5":
                    return "Five of Diamonds";
                case "6":
                    return "Six of Diamonds";
                case "7":
                    return "Seven of Diamonds";
                case "8":
                    return "Eight of Diamonds";
                case "9":
                    return "Nine of Diamonds";
                case "10":
                    return "Ten of Diamonds";
                case "A":
                    return "Ace of Diamonds";
                case "J":
                    return "Jack of Diamonds";
                case "Q":
                    return "Queen of Diamonds";
                case "K":
                    return "King of Diamonds";
            }

        } else if (suit.equals("H")) {
           //Determines rank and returns description
            switch (rank) {
                case "2":
                    return "Two of Hearts";
                case "3":
                    return "Three of Hearts";
                case "4":
                    return "Four of Hearts";
                case "5":
                    return "Five of Hearts";
                case "6":
                    return "Six of Hearts";
                case "7":
                    return "Seven of Hearts";
                case "8":
                    return "Eight of Hearts";
                case "9":
                    return "Nine of Hearts";
                case "10":
                    return "Ten of Hearts";
                case "A":
                    return "Ace of Hearts";
                case "J":
                    return "Jack of Hearts";
                case "Q":
                    return "Queen of Hearts";
                case "K":
                    return "King of Hearts";
            }

        } else if (suit.equals("S")){
            //Determines rank and returns description
            switch (rank) {
                case "2":
                    return "Two of Spades";
                case "3":
                    return "Three of Spades";
                case "4":
                    return "Four of Spades";
                case "5":
                    return "Five of Spades";
                case "6":
                    return "Six of Spades";
                case "7":
                    return "Seven of Spades";
                case "8":
                    return "Eight of Spades";
                case "9":
                    return "Nine of Spades";
                case "10":
                    return "Ten of Spades";
                case "A":
                    return "Ace of Spades";
                case "J":
                    return "Jack of Spades";
                case "Q":
                    return "Queen of Spades";
                case "K":
                    return "King of Spades";
            }


        } else if (suit.equals("C")) {
            //Determines rank and returns description
            switch (rank) {
                case "2":
                    return "Two of Clubs";
                case "3":
                    return "Three of Clubs";
                case "4":
                    return "Four of Clubs";
                case "5":
                    return "Five of Clubs";
                case "6":
                    return "Six of Clubs";
                case "7":
                    return "Seven of Clubs";
                case "8":
                    return "Eight of Clubs";
                case "9":
                    return "Nine of Clubs";
                case "10":
                    return "Ten of Clubs";
                case "A":
                    return "Ace of Clubs";
                case "J":
                    return "Jack of Clubs";
                case "Q":
                    return "Queen of Clubs";
                case "K":
                    return "King of Clubs";
            }

        }
        return "You must input a correct rank and suit. Program terminated.";
    }

    /** 
     * This is the main method.
     * @param args takes command line arguments.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        //Get user input
        System.out.print("Enter a card rank and suit as single characters: ");
        String cardDescription = in.next();
        String cardRank = Character.toString(cardDescription.charAt(0));
        String cardSuit = Character.toString(cardDescription.charAt(1));
        in.close();
        //Determines card description. Output.
        String description = getCardDescription(cardRank, cardSuit);
        System.out.print(description);

    }
}