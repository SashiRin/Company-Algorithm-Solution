package wish;

import java.util.Arrays;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wish
 * File Name : CountSmaller
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class CountSmaller {

    /**
     * 求对于第二个vector中每个元素，第一个vector中有多少个元素比它小
     * @param num1
     * @param num2
     * @return
     */

    public static int[] countSmaller(int[] num1, int[] num2) {
        int[] res = new int[num2.length];
        Arrays.sort(num1);
        for (int i = 0; i < num2.length; i++) {
            res[i] = binarySearch(num1, num2[i]);
        }
        return res;
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] < target) return end + 1;
        if (nums[start] >= target) return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] >= target) return start;
        return end;
    }

    public static void main(String[] args) {

    }
}
