//Leetcode 80
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int oStart = 0;
        int oEnd = 0;
        int wStart = 0;
        int wEnd = 0;
        int curNum = nums[0];
        int coutinusNums = 0;
        int totalCount = 0;
        while(true){
            for(int i = oStart; i < nums.length; i++){
               if(nums[i] != curNum){
                   oEnd = i - 1;
                   coutinusNums = i - oStart;
                   break;
               }else if(i == nums.length - 1){
                   oEnd = i;
                   coutinusNums = oEnd - oStart + 1;
                   break;
               }
            }
            if(coutinusNums >= 3){
                wEnd = wStart + 2;
                totalCount += 2;
            }else{
                wEnd = wStart + coutinusNums;
                totalCount += coutinusNums;
            }
            for(int i = wStart; i < wEnd; i++){
                nums[i] = curNum;
            }
            wStart = wEnd;
            oStart = oEnd + 1;
            if(oStart < nums.length){
                curNum = nums[oStart];
            }else{
                break;
            }
        }
//        for(int i = 0; i < wEnd; i++){
//            System.out.print(nums[i] + " ");
//        }
        return totalCount;
    }
}
