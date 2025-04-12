import java.util.Scanner;
/**
 * Programming Assignment 5
 * @ author Essa Imhmed 
 * CS123 
 * 03/23/2025
 * 
 * This program asks user for an input of rank and suit of a card. The program guides used of abbreviations used. Once values are entred
 * the program will then compare user input and display full card description or if input is invalid a message "Unknown" will be displayed. 
  */
public class CardDescription {    //public class Card Description


    public static String getCardDescription(String rank, String suit) {  //a getCardDescription method is created, using a string rank and a string suit
        String notation = rank+suit;  //creating a new string called notation which combines rank string and suit string
        
        

        if ((notation.length()<=3) && (rank == notation.substring(0, notation.length()-1)) && (suit == notation.substring(notation.length()-1, notation.length()))); {   //creation of if loop, based on number of characters in string notation, and assigning index location to rank string and suit string 
            if (rank.equalsIgnoreCase("A")) {  //nesting an if loop, with check is operator input for rank equal to letter A; equal also ignores is the input upper or small case 
                rank = "Ace";} //assigning rank value to Ace if operator input is letter A
            else if (rank.equalsIgnoreCase("K")) { //else is a check is operator input is leeter K; equal also ignores is the input upper or small case 
                rank = "King";} //assigning rank value to King if operator input is letter K
            else if (rank.equalsIgnoreCase("Q")) { //else is a check is operator input is leeter Q; equal also ignores is the input upper or small case
                rank = "Queen";} //assigning rank value to Queen if operator input is letter Q
            else if (rank.equalsIgnoreCase("J")) { //else is a check is operator input is leeter J; equal also ignores is the input upper or small case
                rank = "Jack"; } //assigning rank value to Jack if operator input is letter J
            else if (rank.equals("10")) { //else is a check is operator input a number 10
                rank = "Ten"; } //assigning rank value to Ten if operator input is a number 10
            else if (rank.equals("9")) { //else is a check is operator input a number 9
                rank= "Nine"; } //assigning rank value to Nine if operator input is a number 9
            else if (rank.equals("8")) { //else is a check is operator input a number 8
                rank = "Eight"; } //assigning rank value to Eight if operator input is a number 8
            else if (rank.equals("7")) { //else is a check is operator input a number 7
                rank = "Seven"; } //assigning rank value to Seven if operator input is a number 7
            else if (rank.equals("6")) { //else is a check is operator input a number 6
                rank = "Six"; } //assigning rank value to Six if operator input is a number 6
            else if (rank.equals("5")) { //else is a check is operator input a number 5
                rank = "Five";} //assigning rank value to Five if operator input is a number 5
            else if (rank.equals("4")) { //else is a check is operator input a number 4
                rank = "Four";} //assigning rank value to Four if operator input is a number 4
            else if (rank.equals("3")) { //else is a check is operator input a number 3
                rank = "Three";} //assigning rank value to Three if operator input is a number 3
            else if (rank.equals("2")) { //else is a check is operator input a number 2
                 rank = "Two";} //assigning rank value to Two if operator input is a number 2
            else  //otherwise
            return "Unknown";} //for all other instances of entries of operator input the message Unknow will be displayed
            {
            if (suit.equalsIgnoreCase("D")) {  //nesting an if loop, with check is operator input for suit equal to letter D; equal also ignores is the input upper or small case
                suit = "Diamond"; } //assigning suit value to Diamond if operator input is letter D
            else if (suit.equalsIgnoreCase("H")) { //else is a check is operator input is leeter H; equal also ignores is the input upper or small case
                suit = "Hearts";} //assigning suit value to Hearts if operator input is letter H
            else if (suit.equalsIgnoreCase("S")) { //else is a check is operator input is leeter S; equal also ignores is the input upper or small case
                suit = "Spades";} //assigning suit value to Spades if operator input is letter S
            else if (suit.equalsIgnoreCase("C")) { //else is a check is operator input is leeter C; equal also ignores is the input upper or small case
                suit = "Clubs";} //assigning suit value to Clubs if operator input is letter C
            else //otherwise
            return "Unknown";} //for all other instances of entries of operator input the message Unknow will be displayed

        return rank + " of " + suit;  //if rank and suit input values are valid a value will be returned of rank card full description plus word of plus suit full description
    }
    

    public static void main(String[] args) {  //this is the main method
        Scanner in = new Scanner(System.in);  //initiating scanner for operator input
        System.out.println ("Enter card rank. \n Use A for Ace, J for Jack, Q for Queen, K for King or a numeric value 2 to 10."); //prompting operator to enter card rank, with explanation of abreviations
        String rank = in.next(); //reading operator input to string rank
        System.out.println ("Enter card suit. \n Use D for Diamond, H for Heatrs, S for Spades, C for Clubs."); //prompting operator to enter card suit, with explanation of abreviations
        String suit = in.next(); //reading operator input to string suit

        System.out.println ("The card you chose is: " + rank + suit); //displaying a message of operator input
        
        System.out.println ("The card is: " + getCardDescription(rank, suit)); //prinitng put results, calling getCardDescription method and it's output values
    }
}


