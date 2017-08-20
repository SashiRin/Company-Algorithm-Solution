package goldmanSachs;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : FirstUniqueChar
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class FirstUniqueChar {

    /**
     * input是string，找到这个string中第一个unique的char，返回string类型，用map做的。
     * @param input
     * @return
     */


    public static String firstUniqueChar(String input) {
        if (input == null || input.length() == 0) return "";
        HashMap<Character, HashMap<Integer, Integer>> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (map.containsKey(c)) {
                HashMap<Integer, Integer> tmp = map.get(c);
                tmp.put(0, 0);
                map.put(c, tmp);
            } else {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(1, i);
                map.put(c, tmp);
            }
        }
        for (Map.Entry<Character, HashMap<Integer, Integer>> entry : map.entrySet()) {
            HashMap<Integer, Integer> tmp = entry.getValue();
            if (tmp.size() == 1) {
                res = Math.min(res, tmp.get(1));
            }
        }
        return String.valueOf(input.charAt(res));
    }

    public static void main(String[] args) {
        String s = "racecars";
        System.out.println(firstUniqueChar(s));
    }
}
