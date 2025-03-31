import java.util.Scanner;
// Javadoc documentation is now available for this program.
/**
 * This program reads, scales, and reverses a sequence of numbers.
 * @author Lauren White
 * */
public class NumberModifier
{ 
    /*
    * General fixes: Corrected spacing. 
    * Javadoc documentation is now available for every method.
    * Fixed camel case and names for variables and methods.
    * Moved main method to the end of the program.
    */

    /**
    * Reads a sequence of floating-point numbers.
    * @param n is the number of inputs as a floating point number.
    * @return inputs as a floating point number.
    */
   public static double[] readInputs(int n)
   {
        // Fixes: Corrected line separation and spacing. Closed scanner. Added comment.
        
        // Gets user input.
        System.out.println("Enter " + n + " numbers: " );
        Scanner in = new Scanner(System.in); 
        double[] inputs = new double[n];
        in.close();
        
        // Puts user input into an array.
        for(int i = 0; i < inputs.length; i++)
        {
            inputs[i] = in.nextDouble();
        }

        return inputs;
   }
   /**
    * Multiplies all elements of an array by a factor.
    * @param values takes numbers from the user as a floating point number.
    * @param factor takes the number you want to factor the values by 
    * as a floating point number.
    */
    public static void multiply(double[] values, double factor)
    {
        // Iterates through the array and multiplies each number by factor.
        for(int i=0;i<values.length;i++)
        {
            values[i] = values[i]*factor;
        }
    }
    
    // Fix: Changed variable name from v to a descriptive name.

    /**
    * This method prints an array in reverse order.
    * @param values takes numbers from readInputs() as floating point numbers.
    */
    public static void printReversed(double[] values)
    {
        // Traverse the array in reverse order, starting with the last element.
        for(int i=values.length-1;i>=0;i--)
        {
            System.out.print(values[i] + " ");
        }

        System.out.println();
    } 

   /**
    * This is the main method.
    * @param args takes command line arguments.
    */
    public static void main(String[] args) 
    {        
        // Fixes: Added spacing. Added a comment. Changed variable a to a fitting name.

        // Reads user inputs, multiplies them, and prints the array in reverse.
        double[] userInput = readInputs(5);
        multiply(userInput, 10);
        printReversed(userInput);
    }
} // Fix: Moved closed bracket
  
