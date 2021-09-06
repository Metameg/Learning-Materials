import java.util.regex.Pattern;

public class PigLatin {
    

    public static String pigIt(String str)  {
        String specialChars ="[$&+,:;=\\\\?@#|/'<>.^*()%!-]";
        String alphanumChars = "[a-zA-Z0-9]";
        Pattern alphanumPattern = Pattern.compile(alphanumChars);
        Pattern regex = Pattern.compile(specialChars);
        String pigStr = "";

        if (!alphanumPattern.matcher(str).find())
            return str;

        else {
        
            // Creates a list of words in str
            String[] wordList = str.split(" ");

            // Removes first character of each word and adds ay at end
            for (String word: wordList) {
                if (regex.matcher(word).find()) {
                    System.out.println(word);
                    String tempWord = word.replaceAll(specialChars,"");
                    System.out.println(tempWord);
                    tempWord = tempWord + tempWord.charAt(0) ;
                    tempWord = tempWord.substring(1) + "ay";
                    
                    word = tempWord + word.charAt(word.length()-1);
                    System.out.println(word);
                    
                }
                else {
                    word = word + word.charAt(0) ;
                    word = word.substring(1) + "ay ";      
                }
                pigStr += word;
            }
            // removes final space character in the pigStr
            if (specialChars.indexOf(pigStr.charAt(pigStr.length()-1)) == -1)
                pigStr = pigStr.substring(0, pigStr.length()-1); 
            return pigStr;
        }
    }

    public static void main(String[] args) {
        System.out.print(pigIt("!"));
    }
}



