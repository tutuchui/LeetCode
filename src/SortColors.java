public class SortColors {
    public void sortColors(int[] nums) {
        //Counting Sort
//        int[] colors = new int[3];
//        for(int i = 0; i < nums.length;i++){
//            colors[nums[i]]++;
//        }
//        int k = 0;
//        for(int i = 0; i < colors.length; i++){
//            for(int j = 0; j < colors[i];j++){
//                nums[k] = i;
//                k++;
//            }
//        }

        //荷兰三色国旗问题
        int p0 = 0;
        int cur  = 0;
        int p2 = nums.length - 1;
        int tmp = 0;
        while(cur <= p2){
            if(nums[cur] == 0){
                tmp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = tmp;
                p0++;
                cur++;
            }

            else if(nums[cur] == 2){
                tmp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = tmp;
                p2--;
            }
            else
                cur++;
        }
    }
}
