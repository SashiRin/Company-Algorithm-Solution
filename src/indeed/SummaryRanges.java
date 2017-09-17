package indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : SummaryRanges
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SummaryRanges {
    // time : O(n)
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        int start = 0;
        for (int j = 0; j < nums.length; ++j){
            start = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                ++j;
            // put the range into the list
            /*
            follow up是有重复数字，但数组依然排序
            while (j + 1 < nums.length && (nums[j + 1] == nums[j] + 1 || nums[j + 1] == nums[j]))
                ++j;
             */
            if (start == j)
                summary.add(nums[start] + "");
            else
                summary.add(nums[start] + "->" + nums[j]);
        }
        return summary;
    }

}
