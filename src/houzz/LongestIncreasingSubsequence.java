package houzz;

import java.util.Arrays;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : LongestIncreasingSubsequence
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 1, 18, 88};
        lengthOfLIS(nums);
    }
}
