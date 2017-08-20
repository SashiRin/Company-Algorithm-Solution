package goldmanSachs;

import java.util.ArrayList;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : LeastNumber
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class LeastNumber {
    /**
     * 找一个array中的第二小的数字
     * @param nums
     * @return
     */

    public static int leastNumber(ArrayList<Integer> nums) {
        Integer first = null;
        Integer second = null;
        for (Integer num : nums) {
            if (first == null) {
                first = num;
                continue;
            }
            if (first != null && second == null) {
                second = first < num ? num : first;
                first = (first == second ? num : first);
                continue;
            }
            if (first != null && second != null && num <= second) {
                if (num <= first) {
                    second = first;
                    first = num;
                } else {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        nums.add(9);
        nums.add(10);
        System.out.println(leastNumber(nums));
    }
}
