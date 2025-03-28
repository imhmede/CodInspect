 import java.util.Scanner;
 /**
  * @author Ludwig Scherer
  
  */

//This program reads, scales, and reverses a sequence of numbers.
public class Main
{public static void main(String[]args )
   {        
      double[] a=read_inputs(5);multiply(a, 10);printreversed(a);
   }
   // Reads a sequence of floating-point numbers.
   // n is the number of inputs to read
   public static double[] read_inputs(int n)
   {
      System.out.println("Enter "+n+" numbers: " );
      Scanner in=new Scanner(System.in); double[] inputs=new double[n];for(int i=0;i<inputs.length;i++){inputs[i]=in.nextDouble();}return inputs;
   }
   //Multiplies all elements of an array by a factor.
   public static void multiply(double[] values,double factor)
   {
      for(int i=0;i<values.length;i++){values[i]=values[i]*factor;}
   }
   //Prints an array in reverse order.
   public static void printreversed(double[] v)
   {// Traverse the array in reverse order, starting with the last element
      for(int i=v.length-1;i>=0;i--)
      {System.out.print(v[i]+" ");}
      System.out.println();
   }}
