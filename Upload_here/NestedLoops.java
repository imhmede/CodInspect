public class NestedLoops {
    public static void main(String[] args) {
        String line = "Message me when you get my Message";
        String substring = "age";
        int occurrence = 0;
        for (int i = 0; i < line.length(); i++) {
            String charFromLine = Character.toString(line.charAt(i));
            if (Character.toString(substring.charAt(0)).equalsIgnoreCase(charFromLine)) {
                int j = 0;
                for (j = 0; j < substring.length(); j++) {
                    //i += j;
                    charFromLine = Character.toString(line.charAt(i));
                    if (!Character.toString(substring.charAt(j)).equalsIgnoreCase(charFromLine)) {
                        break;
                    }
                    i += 1;
                }
                if (j == substring.length()) {
                    occurrence += 1;
                }
                
            }
        }
        System.out.println(occurrence);
    }
}
