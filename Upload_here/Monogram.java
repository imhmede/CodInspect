import java.util.Scanner;
/*
@author Essa Imhmed
@date February 16 2025
* This Program derives the monogram initials of any string statement, but is specifically meant for use with names
* Converts names into initials.
*/

public class Monogram {
    /*
     * This method uses an array and a for loop to retrieve the first index of each name entered by the user.
     * @param fullname A String statement (a name) entered by the user with spaces between each name.
     */
    public static String getMonogram(String fullName) {
        
        String[] names= fullName.split(" ");
        String monogram = "";

        for (int i = 0;i<names.length;i++){
            monogram = monogram + names[i].charAt(0);
        }
        return monogram;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.print("Enter your full name: ");
        name = scanner.nextLine();
        System.out.printf("The Monogram of %s is %s\n", name, getMonogram(name));
        
        scanner.close();
    }
}