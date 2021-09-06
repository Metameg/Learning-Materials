import java.util.ArrayList;

public class MexicanWave {
    public static String[] wave(String str) {
        
        ArrayList<String> resultList = new ArrayList<String>();
        String[] result = new String[str.length()];

        for (int i=0; i<str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            else {
                str = str.toLowerCase();
                char capitalize = str.charAt(i);
                capitalize = Character.toUpperCase(capitalize);
                str = str.substring(0,i) + capitalize + str.substring(i+1);
                resultList.add(str);
                
           }
        }
        result = resultList.toArray(new String[0]);

        return result;
    }

    public static void main(String[] args) {
        System.out.print(wave("hello world"));
    }
}
