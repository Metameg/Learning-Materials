import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean isPalindrome = false;
        String input = scnr.nextLine();
        int i = 0;
        int j = input.length()-1;

        
        while (i<j) {
            if (input.charAt(i) == input.charAt(j)) {
                isPalindrome = true;
            }
            else {
                isPalindrome = false;
                break;
            }
        ++i;
        --j;
        }

        System.out.print(isPalindrome);
    
        scnr.close();
        
        
    }        
}
    
      
   


