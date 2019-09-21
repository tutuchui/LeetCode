import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_Sum_Recursive {
    public List<List<Integer>> kSum(int[] nums, int target, int k){
        Arrays.sort(nums);
        int[] stack = new int[k];
        Arrays.fill(stack,0x3f3f3f);
        int stack_index = -1;
        int begin = 0;
        List<List<Integer>> ans = K_Sum_Recursive_Template(nums, stack, stack_index,k,begin,target);
        return ans;
    }

    private List<List<Integer>> K_Sum_Recursive_Template(int[] nums,int[] stack, int stack_index, int k, int begin, int target){
        List<List<Integer>> ans = new ArrayList<>();

        if(k == 2){
            List<Integer> temp_ans;
            int left = begin;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] > target){
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    temp_ans = new ArrayList<>();
                    stack[++stack_index] = nums[left];
                    stack[++stack_index] = nums[right];
                    for(int i = 0; i <= stack_index;i++){
                        temp_ans.add(stack[i]);
                    }
                    ans.add(temp_ans);

                    stack[stack_index--] = 0x3f3f3f3f;
                    stack[stack_index--] = 0x3f3f3f3f;

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(right > left && right < nums.length -1 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }else{
            int target_temp;
            for(int i = begin; i < nums.length - k + 1; i++){
                if(i > begin && nums[i] == nums[i-1]){
                    continue;
                }
                target_temp = target - nums[i];
                stack[++stack_index] = nums[i];
                List<List<Integer>> ans_temp = K_Sum_Recursive_Template(nums,stack,stack_index,k-1,i+1,target_temp);
                stack[stack_index--] = 0x3f3f3f;
                ans.addAll(ans_temp);
            }
        }
        return ans;
    }
}
