package houzz;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : PrintAllLongestIncreasingSubsequence
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PrintAllLongestIncreasingSubsequence {
    /*
        找出所有longest increasing subsequence:
        先找出最长的长度，然后找出所有的increasing subsequence
     */

    static int count = 0;

    public static List<List<Integer>> printAllSubsequence(int[] nums) {

        int[] dp = new int[nums.length];

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, count, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == count) count++;
        }

        Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }
    public static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() == count) {
            res.add(new ArrayList(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
