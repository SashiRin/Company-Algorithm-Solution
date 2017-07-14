package facebook;

import java.util.*;

/**
 * Created by Edward on 13/07/2017.
 */

public class TwoSum {

    /**
     * 1. Two Sum
     * time : O(n) space : O(n)
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1}; // corner case
        }

        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    /**
     * 167. Two Sum II - Input array is sorted
     * time : O(log(n)) space : O(1)
     * @param numbers
     * @param target
     * @return
     */

    public static int[] twoSum2(int[] numbers, int target) {

        if (numbers ==  null || numbers.length < 2) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * two sum with duplicate number (sort array)
     * time : O(n^2) space : O(n)
     * @param nums
     * @param target
     * @return
     */

    public static List<int[]> twoSumDup(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }

        List<int[]> res = new ArrayList<>();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(nums[i], set);
            } else {
                map.get(nums[i]).add(i);
            }
            if (map.containsKey(target - nums[i])) {
                Set<Integer> set = map.get(target - nums[i]);
                for (Integer num : set) {
                    if (i != num) {
                        res.add(new int[]{i, num});
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 4, 4, 7, 11, 15};
        List<int[]> res = new ArrayList<>();
        res = twoSumDup(nums, 6);
        for (int[] num : res) {
            System.out.println(Arrays.toString(num));
        }
    }
}
