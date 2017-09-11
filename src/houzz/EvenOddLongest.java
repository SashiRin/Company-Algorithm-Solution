package houzz;

import java.util.HashMap;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : EvenOddLongest
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class EvenOddLongest {
    /*
    n（奇数）：3n＋1
    n（偶数）：n/2
    每个数都能到1，比如：5->16->8->4->2->1, 长度为5。
    找到1-1000中序列最长为多少。
     */
    public static int longest(int num) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= num; i++) {
            max = Math.max(max, helper(map, i));
        }
        return max;
    }
    public static int helper(HashMap<Integer, Integer> map, int num) {
        int count = 0;
        while (num != 1) {
            if (map.containsKey(num)) {
                count = count + map.get(num);
                break;
            }
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
            System.out.println("ddfs");
        }
        if (!map.containsKey(num)) {
            map.put(num, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longest(1000));
    }
}
