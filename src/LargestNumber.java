//Leetcode 179
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String result = "";
        for(int i = nums.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(!curStrCompare(String.valueOf(nums[j]),String.valueOf(nums[j+1]))){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int num : nums){
            result += String.valueOf(num);
        }
        String newResult;
        for(int i = 0; i < result.length() - 1; i++){
            if(result.charAt(i)!=0){
                break;
            }
            newResult = result.substring(i+1);
        }
        return result;
    }

    public boolean curStrCompare(String int1, String int2){
        if(int1.length() > int2.length()){
            for(int i = 0; i < int2.length(); i++){
                if(int1.charAt(i) > int2.charAt(i)){
                    return true;
                }
                else if(int1.charAt(i) < int2.charAt(i)){
                    return false;
                }
            }
            String curStr = int1.substring(int2.length()) + int2;
            return curStrCompare(curStr,int1);
        }

        else if(int1.length() < int2.length()){
            for(int i = 0; i < int1.length(); i++){
                if(int1.charAt(i) > int2.charAt(i)){
                    return true;
                }
                else if(int1.charAt(i) < int2.charAt(i)){
                    return false;
                }
            }
            String curStr = int2.substring(int1.length()) + int1;
            return curStrCompare(int2,curStr);
        }
        else {
            for(int i = 0; i < int1.length(); i++){
                if(int1.charAt(i) > int2.charAt(i)){
                    return true;
                }
                else if(int1.charAt(i) < int2.charAt(i)){
                    return false;
                }
            }
            return false;
        }
    }
}
