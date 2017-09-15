package wepay;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : unqiueChar
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class unqiueChar {
    //给一个char的字符串，找出里面不重复的字符
    public static char[] unqiue(char[] arry) {
        HashMap<Character, Integer> map = new HashMap();
        List<Character> res = new ArrayList<>();
        for (Character c : arry) {
            if (map.containsKey(c)) {
                map.put(c, 2);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        char[] ret = new char[res.size()];
        int k = 0;
        for (Character c : res) {
            ret[k++] = c;
        }
        return ret;
    }
}
