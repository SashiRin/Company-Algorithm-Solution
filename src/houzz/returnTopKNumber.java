package houzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : returnTopKNumber
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class returnTopKNumber {

    /**
     * 给一串string，里面有数字, return 最大的top k 个数字，比如k = 3：
     input = “dfsfs980sdf123poier110poipoikkj-10”
     output = [980, 123, 110]

     **注意：可以有负数，如果是负数，数字前面那个字符 ‘ - ’ 为负号~
     * @param s
     * @return
     */

    public static int[] topK(String s, int k) {
        int[] res = new int[k];
        ArrayList<Integer> ret = new ArrayList<>();
        int num = 0;
        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                if ((i < s.length() - 1) && Character.isDigit(s.charAt(i + 1))) {
                    isNegative = true;
                }
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == s.length() - 1 || (i < s.length() && !Character.isDigit(s.charAt(i + 1)))) {
                    if (isNegative) {
                        ret.add(0 - num);
                        isNegative = false;
                    }
                    else ret.add(num);
                    num = 0;
                }
            }
        }
        //Collections.sort(list);
        //Collections.reverse(list);
        Collections.sort(ret, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "df-1111sfs-980sdf123poier110poipoikkj-10";
        System.out.println(Arrays.toString(topK(input, 3)));
    }
}
