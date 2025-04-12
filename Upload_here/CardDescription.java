import java.util.Scanner;


 /**
  * This program reads out Card Notation into a Card Description
  * @author Essa Imhmed
  */
public class CardDescription {
    
    /**
     * This method checks a value from the user and prints a description of the values into a string
     * @param rank a string representing the value of the card
     * @param suit a string representing the suit of the card
     * @return a string expressing whether the input value is valid or not
     */
    public static String getCardDescription(String rank, String suit) {

        if (!(rank.equals("A") || rank.equals("J") || rank.equals("Q") || rank.equals("K"))){ //check if the rank is valid
            if (Integer.parseInt(rank) < 2 || Integer.parseInt(rank) > 10)
                {
                return "Invalid Input";
                }
        }
        if (!(suit.equals("D") || suit.equals("H") || suit.equals("S") || suit.equals("C"))){ //check if the suit is valid
            return "Invalid Input";
        }

        //now find the matching rank to it's description
        if (rank.equals("A")){
            System.out.print("Ace of ");
        }
        else if (rank.equals("J")){
            System.out.print("Jack of ");
        }
        else if (rank.equals("Q")){
            System.out.print("Queen of ");
        }
        else if (rank.equals("K")){
            System.out.print("King of ");
        }
        else {
            System.out.print(rank + " of ");
        }
        
        //now find the matching suit
        if (suit.equals("D")){
            System.out.print("Diamonds");
        }
        else if (suit.equals("H")){
            System.out.print("Hearts");
        }
        else if (suit.equals("S")){
            System.out.print("Spades");
        }
        else {
            System.out.print("Clubs");
        }
        return "";
    }
    
    /**
     * This is the main method.
     * @param args a command-line argument
     */
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the notation for card: ");
        String card = in.next();
        String rank = card.substring(0,card.length() - 1);
        String suit = card.substring(card.length() -1);

        System.out.print(getCardDescription(rank, suit));
        in.close();
    }

}
