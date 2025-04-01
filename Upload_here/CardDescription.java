/**
 * @author Nicol Salaris
 * CS123
 * ID: 660288257
 */
package Upload_here;

import java.util.Scanner;
public class CardDescription{
    //asking the user for input for card to get the rank and suit
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the rank of the card");
        String rank= in.next();
        System.out.println("Enter the suit of the card");
        String suit= in.next();
        suit = suit.toUpperCase();
        rank = rank.toUpperCase();
        System.out.println(getCardDescription(rank,suit));
    }
    /*
     * @ param rank: the rank of the card
     * @ param suit: the suit of the card
     * @ return: the description of the card
     * This method takes the rank and suit of a card and returns the description of the card
     * 
     */
    public static String getCardDescription(String rank, String suit) {
        String card="";
        if(rank.equals("A")){
            card+="Ace";
        }
        else if(rank.equals("2")){
            card+="Two";
        }
        else if(rank.equals("3")){
            card+="Three";
        }
        else if(rank.equals("4")){
            card+="Four";
        }
        else if(rank.equals("5")){
            card+="Five";
        }
        else if(rank.equals("6")){
            card+="Six";
        }
        else if(rank.equals("7")){
            card+="Seven";
        }
        else if(rank.equals("8")){
            card+="Eight";
        }
        else if(rank.equals("9")){
            card+="Nine";
        }
        else if(rank.equals("10")){
            card+="Ten";
        }
        else if(rank.equals("J")){
            card+="Jack";
        }
        else if(rank.equals("Q")){
            card+="Queen";
        }
        else if(rank.equals("K")){
            card+="King";
        }
        else{
            return "Invalid Rank";
        }
        card+=" of ";
        if(suit.equals("D")){
            card+="Diamonds";
        }
        else if(suit.equals("H")){
            card+="Hearts";
        }
        else if(suit.equals("S")){
            card+="Spades";
        }
        else if(suit.equals("C")){
            card+="Clubs";
        }
        else{
            return "Invalid Suit";
        }
        return card;
    }
}