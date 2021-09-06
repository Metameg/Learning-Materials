public class LineTickets {
    public static String Tickets(int[] peopleInLine) {
        int num25 = 1;
        int num50 = 0;

        if (peopleInLine[0] != 25)
            return "NO";
        
        for (int i=1; i<peopleInLine.length; ++i){
            
            if (peopleInLine[i] == 25)
                num25 += 1;
            
            else if (peopleInLine[i] == 50) {
                
                if (num25 >= 1) {
                    num50 += 1;
                    num25 -= 1;
                
                } else return "NO";
            }
            
            else if (peopleInLine[i] == 100) {               
                
                if ((num50 >=1) && (num25 >=1 )) {
                    num50 -= 1;
                    num25 -=1;
                }

                else if ((num50 == 0) && (num25 >= 3)) 
                    num25 -= 3;
                
                else return "NO";
            }
        }
        
        return "YES";     
    }
    public static void main(String[] args) {
        System.out.print(Tickets(new int[] {25, 25, 50, 50, 100}));
    }
}
