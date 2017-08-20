package facebook;

import java.util.*;

public class TwoSumWithDuplicateNumber {
    /**
     * 1. Two Sum (follow up: duplicate number)
     * two sum with duplicate numberO(n^2)
     *
     * time : O(n^2);
     * space: O(n);
     * @param nums
     * @param target
     * @return
     */

    public static List<int[]> findNumbersThatSumToTarget(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(nums[i], set);
            }
            if (map.containsKey(target - nums[i])) {
                for (Integer j : map.get(target - nums[i])) {
                    if (j != i) {
                        int[] ret = new int[]{i, j};
                        res.add(ret);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4,5,6,6,6,3,4,5,10,8,1,9};
        List<int[]> res = findNumbersThatSumToTarget(nums, 10);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }

}
