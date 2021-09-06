public class PangramChecker {
    public static boolean check(String sentence){
        String alphabet = "abcdefghijklmnopqrstuvwyz";

        for (int i=0; i<sentence.length(); ++i) {
            Character c = sentence.charAt(i);
            c = Character.toLowerCase(c);
            System.out.println(c);

            // if the letter c is in the alphabet, remove it from alphabet
            if (alphabet.contains(c.toString())) { 
                alphabet = alphabet.replace(c.toString(), "");
            }      
        }

        if (alphabet.length() == 0) 
            return true;
        
        else 
            return false;
        
    }

    public static void main(String[] args) {
        System.out.print(check("The quick bron fox jumps over the lazy dog."));
    } 
  }