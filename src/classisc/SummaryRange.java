package classisc;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 1;
        while(end <= nums.length) {
            if((end != nums.length) && (nums[end] - nums[end - 1] == 1)) {
                end++;
            }else{
                if(end - start == 1) {
                    list.add(String.valueOf(nums[start]));
                }else {
                    list.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end;
                end = start + 1;
            }
        }
        return list;
    }
}
