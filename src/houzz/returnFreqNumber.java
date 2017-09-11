package houzz;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : returnFreqNumber
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class returnFreqNumber {
    public static int topK(String s) {
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
        int res = 0;
        int freq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number : ret) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (freq < entry.getValue()) {
                freq = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "df-1111sfs980sd980f980123poier110poipo110ikkj-10";
        System.out.println(topK(input));
    }
}
