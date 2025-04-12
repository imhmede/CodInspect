import java.util.Scanner;
/**
 * this program reads a card description based on a notation
 * @author Essa Imhmed
 */
public class CardDescription{
      /**
     * This method finds the min number in the array
     * @param rank 
     * @param suit
     * @return index
     */
  public static String getCardDescription(String rank,String suit){
    {
        String rankDescription = "";
        String suitDescription = "";
        if(rank.equalsIgnoreCase("A")){
          rankDescription="Ace";
        }else if(rank.equalsIgnoreCase("J")){
          rankDescription="Jack";
        }else if(rank.equalsIgnoreCase("K")){
          rankDescription="King";
        }else if(rank.equalsIgnoreCase("Q")){
        rankDescription="Queen";
        }else{
          rankDescription=rank;
        }
        
        if(suit.equalsIgnoreCase("S")){
          suitDescription="Spades";
        }else if(suit.equalsIgnoreCase("D")){
          suitDescription="Diamonds";
        }else if(suit.equalsIgnoreCase("H")){
          suitDescription="Hearts";
        }else if(suit.equalsIgnoreCase("C")){
          suitDescription="Clubs";}
        
      
        
            return rankDescription +" of "+ suitDescription;
        
    }
    }  
  /**
   * @param rank,suit
   * This methods asks user for input notation
   *and prints out the card description
   */
      
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter card notation: ");
    
      String code = in.nextLine();
      in.close();
      String rank = Character.toString(code.charAt(0));
      String suit = Character.toString(code.charAt(1));
      String message= getCardDescription(rank,suit);
      System.out.println(message);


    }

  }
  
    

    
       




    
    

  
    
        

    


        

        


    





