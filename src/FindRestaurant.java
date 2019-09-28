import java.util.HashMap;
import java.util.HashSet;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        HashMap<String, Integer> shareRest = new HashMap<>();
        HashSet<String> sharSet = new HashSet<>();
        int minIndex = (int) Double.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
            set1.add(list1[i]);
        }
        for (int i = 0; i < list2.length; i++) {
            int indexSum = -1;
            if (set1.contains(list2[i])) {
                indexSum = map1.get(list2[i]) + i;
                if (indexSum <= minIndex) {
                    minIndex = indexSum;
                    shareRest.put(list2[i], indexSum);
                }

            }
        }

        for (String rest : shareRest.keySet()) {
            if (shareRest.get(rest) == minIndex) {
                sharSet.add(rest);
            }
        }
        String[] result = new String[sharSet.size()];
        int i = 0;
        for (String shar : sharSet) {
            result[i++] = shar;
        }
        return result;
    }
}
