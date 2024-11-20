package graduate;

//Leetcode 04
public class FindMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] resultArray = joinArray(nums1, nums2);
        int length = resultArray.length;
        if (length % 2 == 1) {
            return resultArray[(length - 1) / 2];
        } else {
            System.out.println(resultArray[(length - 1) / 2] + " "+resultArray[(length - 1) / 2 + 1]);
            return (resultArray[(length - 1) / 2] + resultArray[(length - 1) / 2 + 1]) / 2;
        }


    }

    public int[] joinArray(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length + nums2.length];
        int curNum1 = 0;
        int curNum2 = 0;

        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (curNum1 == nums1.length) {
                resultArray[i] = nums2[curNum2];
                curNum2++;
                continue;
            }

            if (curNum2 == nums2.length) {
                resultArray[i] = nums1[curNum1];
                curNum1++;
                continue;
            }

            if (nums1[curNum1] <= nums2[curNum2]) {
                resultArray[i] = nums1[curNum1];
                curNum1++;
            } else {
                resultArray[i] = nums2[curNum2];
                curNum2++;
            }
        }
        return resultArray;
    }
}
