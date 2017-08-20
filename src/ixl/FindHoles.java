package ixl;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : ixl
 * File Name : findHoles
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class FindHoles {
    /**
     * OA question 1
     * @param num
     * @return
     */

    public static int findHoles(int num){
        int res = 0;
        int[] holes = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            res += holes[s.charAt(i) - '0'];
        }
        return res;
    }
}
