import java.util.Scanner;

/**
 * This program reads an integer and breaks it into a sequence of individual digits.
 * Solution for problem 2.
 * @author Essa Imhmed
 * @date Feb 10, 2025
 */
public class Tokenizer {
    
    /**
     * This method tokenize a number into characters
     * @param number a string
     */
    public static void tokenizeIt(String number) {
        System.out.printf("%c %c %c %c %c\n",
            number.charAt(0),
            number.charAt(1),
            number.charAt(2),
            number.charAt(3),
            number.charAt(4)
        );
    }

    /**
     * This is the main method
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer number: ");
        int number = in.nextInt();
        tokenizeIt(Integer.toString(number));
        in.close();
    }
}