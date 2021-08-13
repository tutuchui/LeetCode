public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = 1; j < nums.length - 1; j++){
                for(int k = 2; k < nums.length; k++){
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
//                    if(isValidTriangle(nums[i],nums[j],nums[k])){
//                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
//                        count++;
//                    }
                }
            }
        }
        return count;
    }

    public boolean isValidTriangle(int a, int b, int c){

        return (a + b > c) && (a - b < c) && (a+c>b) && (a-c<b) &&(b+c > a)&&(b-c<a);
    }


}
