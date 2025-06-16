package classisc;

import java.util.Arrays;

//Leetcode 88
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        if(m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }else if(n == 0) {
            return;
        }
        for(int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int p1 = 0; // pointer to nums1
        int p2 = 0; // pointer to nums2
        for(int i = 0; i < m + n; i++) {
            if(temp[p1] < nums2[p2]) {
                nums1[i] = temp[p1];
                if(p1 < m-1) {
                    p1++;
                }else{
                    temp[p1] = Integer.MAX_VALUE;
                }
            }else {
                nums1[i] = nums2[p2];
                if(p2 < n-1) {
                    p2++;
                }else{
                    nums2[p2] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; //pointer to nums1
        int p2 = n - 1; //pointer to nums2
        int cur = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[cur--] = nums1[p1--];
            }else {
                nums1[cur--] = nums2[p2--];
            }
        }
        if(p2 >= 0) {
            for(int i = 0; i <= cur ; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,5,0,0,0};
        int[] nums2 = new int[] {2,2,8};

        new MergeSortedArray().merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
