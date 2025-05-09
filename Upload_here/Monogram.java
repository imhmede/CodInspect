import java.util.Scanner;

/**
 * @author Essa Imhmed
 */
public class Monogram {

    /**
     * Extracts a monogram from a full name by collecting the first character 
     * of each word.
     *
     * @param fullName the full name from which to generate the monogram
     * @return a string containing the monogram
     */
    public String getMonogram(String fullName) {
        String monogram = "";
        int index = 0;

        fullName = fullName.trim();
        if (fullName.isEmpty()) {
            return monogram;
        }

        monogram += fullName.charAt(0);

        while ((index = fullName.indexOf(" ", index)) != -1) {
            index++;
            if (index < fullName.length() && fullName.charAt(index) != ' ') {
                monogram += fullName.charAt(index);
            }
        }

        
        return monogram;
    }

    /**
     * Prompts the user to enter their full name via the console,
     * then prints the generated monogram.
     *
     * @param args command-line arguments
     */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("Enter your full name: ");
    //     String name = scanner.nextLine();
    //     scanner.close();

    //     System.out.printf("The Monogram of %s is %s\n", name, getMonogram(name));
    // }
}
