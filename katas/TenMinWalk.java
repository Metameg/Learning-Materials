public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length == 10) {
            int numN  = 0;
            int numS  = 0;
            int numE  = 0;
            int numW  = 0;

            for (int i=0; i<walk.length; ++i) {
                if (Character.toLowerCase(walk[i]) == 'n') numN+=1;
                else if (Character.toLowerCase(walk[i]) == 's') numS+=1;
                else if (Character.toLowerCase(walk[i]) == 'e') numE+=1;
                else if (Character.toLowerCase(walk[i]) == 'w') numW+=1;
            }
            
            if ((numN == numS) && (numE == numW))
                return true;
            else    
                return false;

        }
        else 
            return false;
    }

    public static void main(String[] args) {
        System.out.print(isValid(new char[] {'w'}));
    }
}