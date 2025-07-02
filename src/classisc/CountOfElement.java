package classisc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountOfElement {
    public static int  countOfElement(int[] listInput1, int[] listInput2) {
        int answer = 0;
        // Write your code here
        if (listInput1.length == 0) {
            return listInput2.length;
        }
        if (listInput2.length == 0) {
            return listInput1.length;
        }

        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < listInput1.length; i++) {
            set1.add(listInput1[i]);
        }
        Set<Integer> joinSet = new HashSet<>();
        for (int i = 0; i < listInput2.length; i++) {
            if (set1.contains(listInput2[i])) {
                joinSet.add(listInput2[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listInput1.length; i++) {
            if (!joinSet.contains(listInput1[i])) {
                result.add(listInput1[i]);
            }
        }
        for (int i = 0; i < listInput2.length; i++) {
            if (!joinSet.contains(listInput2[i])) {
                result.add(listInput2[i]);
            }
        }
        answer = result.size();

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2,3,4,5,5,7,6,9,10};
        int[] nums2 = {11,12,13,4,5,6,7,18,19,20};
        System.out.println(countOfElement(nums1, nums2));
    }
}
