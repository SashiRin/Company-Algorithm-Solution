package goldmanSachs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : KPair
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class KPair {
    /**
     * 求一个数组中和为k的pair的个数（two sum变形）
     * @param nums
     * @param k
     * @return
     */
    public static int kPair(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(k - nums[i])) {
                res++;
            }
            set.add(nums[i]);
        }
        return res;
    }
}
