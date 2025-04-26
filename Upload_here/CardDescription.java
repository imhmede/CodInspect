import java.util.Scanner;

/**
 * This program takes Shorthand string values from user and if the user properly enters the values then the program will
 * describe the card. Uses the standard 52 card deck of playing cards as a reference.
 * @author Essa Imhmed
 * @date March 22nd, 2025.
 */

public class CardDescription {
    
    /*
     * This main method used Scanner class to take input from the user, rank and suit, and sends that information to the method getCardDescription
     * whose return value is printed with a println call.
     */
    public static void main(String[] args) {
        String rank, suit;
        Scanner in = new Scanner(System.in);

        // collecting inputs from user
        System.out.println("Enter in the Card Rank using one character (EXAMPLE: 'A' = ACE (or) '4' = FOUR). \n");
        rank =  in.next();
        System.out.println("Enter in the Card Suit using one character (EXAMPLE: 'H' = HEARTS (or) 'S' = SPADES). \n");
        suit =  in.next();

        // print the return value of getCardDescription
        System.out.println(getCardDescription(rank, suit));
        // close the scanner
        in.close();
        
        }
    /*
     * This method iterates through arrays and uses nested loops to find out if user input matches the related items in the arrays
     * if it does then the method uses the concurring index values to pull information from other correlated arrays of the same size based on user inputs.
     * If the method finds matching values in both loops then it will exit the iterations and return the concatenated string descriptions as one description.
     * for printing in the main method.
     * 
     * if no matching values are found within the iterated arrays and all loops complete then an error message is instead returned for printing in the main method.
     * 
     * @param rank = The string value entered by user representing the RANK
     * @param suit = The string value entered by user representing the SUIT
     */
    public static String getCardDescription(String rank, String suit) 
        {
        String description;
        // arrays for comparison through iteration
        String[] suits= {"H","S","C","D"};
        String[] ranks= {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        
        // arrays whose indexed values correlate appropriately with indexes above. (used when matching values are found.)
        String[] suitDescripts= {"Hearts", "Spades", "Clubs", "Diamonds"};
        String[] rankDescripts= {"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"};
    
        for(int i = 0; i<suits.length; i++)
        {
            if (suits[i].equals(suit)) // search through the suits array to compare each item with the arguement (suit) which is the (string) users input.
            {
                for(int j = 0; j<ranks.length; j++)// if a matching suit is found it will open a new loop to check for rank.
                {
                    if (ranks[j].equals(rank)) // search through the ranks array to compare each item with the arguement (rank) which is the (string) users input.
                    {
                        // execute a concatenation of strings for the return value and exit the method.
                        description = rankDescripts[j] + " Of " + suitDescripts[i];
                        return description;
                    }
                }
            }
        }
        // Return an error if all for loops complete themselves because one matching comparison is not made.
        description = "Invalid Shorthand Value";
        return description;
    }
}
