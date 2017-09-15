package houzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : DivideThree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class DivideThree {
    public static List<Integer> divideTree(int num) {
        if (num <= 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            int x = i;
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 3 == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = divideTree(100);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
