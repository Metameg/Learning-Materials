import java.util.HashMap;
import java.util.Map;

public class FindOdd {
	public static int findIt(int[] arr) {
        int odd = 0;
        int size = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Loop through input array
        for (int i=0; i < size; i++) {
            
            // Add one to elements frequency if already in frequency map
            if (frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            }

            // Else create element in frequency map set to 1
            else {
                frequencyMap.put(arr[i], 1);
            }
        }

        // Print frequency map
        System.out.println("Frequency map:");
        for (int i : frequencyMap.keySet()) {
            System.out.println(i + ": " + frequencyMap.get(i));
            // Set odd frequency value
            if ((frequencyMap.get(i) % 2) != 0) {
                odd = i;
            }
        }

        return odd;
    }

    public static void main(String[] args) {
        System.out.print(findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}