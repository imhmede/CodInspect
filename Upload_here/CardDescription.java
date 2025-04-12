import java.util.Scanner;

/*
 * @author Essa Imhmed
 * @3/27/2025
 * 
 */


public class cardDescription 
{
      /*
       * This method will return a string that gives the card name
       */
      static String getCardDescription(String rank, String suit) {
            String ranking = "";
            String cardSuit = null;
            String cardName = null;
      
            
            if(rank.equals("Q"))
            {
                  ranking = "Queen";
            }
            else if(rank.equals("q"))
            {
                  ranking = "Queen";
            }
            else if(rank.equals("A "))
            {
                  ranking = "Ace";
            }
            else if(rank.equals("a"))
            {
                  ranking = "Ace";
            }
            else if(rank.equals("J"))
            {
                  ranking = "Jack";
            }
            else if(rank.equals("j"))
            {
                  ranking = "Jack";
            }
            else if(rank.equals("K"))
            {
                  ranking = "King";
            }
            else if(rank.equals("k"))
            {
                  ranking = "King";
            }
            else if(rank.equals("2"))
            {
                  ranking = "2";
            }
            else if(rank.equals("3"))
            {
                  ranking = "3";
            }
            else if(rank.equals("4"))
            {
                  ranking = "4";
            }
            else if(rank.equals("5"))
            {
                  ranking = "5";
            }
            else if(rank.equals("6"))
            {
                  ranking = "6";
            }
            else if(rank.equals("7"))
            {
                  ranking = "7";
            }
            else if(rank.equals("8"))
            {
                  ranking = "8";
            }
            else if(rank.equals("9"))
            {
                  ranking = "9";
            }
            else if(rank.equals("10"))
            {
                  ranking = "10";
            }else{
            ranking = "invalid";
            }

            if(suit.equals("H"))
            {
                  cardSuit = "Hearts";
            }
            else if(suit.equals("h"))
            {
                  cardSuit = "Hearts";
            }
            else if(suit.equals("D"))
            {
                  cardSuit = "Diamonds";
            }
            else if(suit.equals("d"))
            {
                  cardSuit = "Diamonds";
            }
            else if(suit.equals("S"))
            {
                  cardSuit = "Spades";
            }
            else if(suit.equals("s"))
            {
                  cardSuit = "Spades";
            }
            else if(suit.equals("C"))
            {
                  cardSuit = "Clubs";
            }
            else if(suit.equals("c"))
            {
                  cardSuit = "Clubs";
            }else{
                  cardSuit = "invalid";
            }
            
            cardName = "The card you have entered is the " + ranking + " of " + cardSuit;
            
            if(ranking.equals("invalid")){
                  return "invalid input";
            }else if(cardSuit.equals("invalid")){
                  return "invalid input";
            }else{
                  return cardName;
            }
        }
/*
 * This is the main method it asks for user input and in theory passes it along
 * It then prints out the card name it recieves from the method it called or reports invalid input
 */
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Please enter the card value (example: A for Ace, 10 for 10)");
String rank = in.nextLine();
System.out.println("Please enter the card suit (example: S for spades, d for diamonds)");      
String suit = in.nextLine();
String cardName = getCardDescription(rank, suit);
System.out.println(cardName);
in.close();
}
}
