package src;

/**
 * This program fins occurrence of a char in a string.
 * @author Essa Imhmed
 */

public class Match {

    public static int find(String line, char target) {
        int occurrence = 0;
        int index = 0;

        while (index < line.length()) {
            if(Character.toString(line.charAt(index)).equalsIgnoreCase(
                Character.toString(target))) {
                    occurrence += 1;
            }
            index += 1;
        }
        return occurrence;
    }
    public static void main(String[] args) {
        String line = "Bananas";
        char target = 'A';
        System.out.println(find(line, target));

    }
}