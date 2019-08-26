import java.util.HashMap;
import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        for(int tmp1 : nums1){
            set.add(tmp1);
        }

        for(int tmp2 : nums2){
            if(set.contains(tmp2)){
                intersectionSet.add(tmp2);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for(int r : intersectionSet){
            result[i++] = r;
        }
        return result;
    }

    public int[] intersectionTwo(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> intersectionMap = new HashMap<>();

        for (int tmp1 : nums1) {
            if (hashMap.containsKey(tmp1)) {
                hashMap.put(tmp1, hashMap.get(tmp1) + 1);
            } else {
                hashMap.put(tmp1, 1);
            }
        }

        for (int tmp2 : nums2) {
            if (hashMap.containsKey(tmp2)) {
                if(intersectionMap.containsKey(tmp2)) {
                    intersectionMap.put(tmp2, intersectionMap.get(tmp2) + 1);
                }else{
                    intersectionMap.put(tmp2, 1);
                }
                hashMap.put(tmp2, hashMap.get(tmp2) - 1);
                if (hashMap.get(tmp2) == 0) {
                    hashMap.remove(tmp2);
                }
            }
        }
        int size = 0;
        for(int key : intersectionMap.keySet()){
            size += intersectionMap.get(key);
        }
        int[] result = new int[size];
        int i = 0;
        for(int key : intersectionMap.keySet()){
           for(int j = 0; j < intersectionMap.get(key);j++){
               result[i++] = key;
           }
        }
        return result;
    }


}
