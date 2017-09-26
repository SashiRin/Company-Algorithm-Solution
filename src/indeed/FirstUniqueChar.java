package indeed;

import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : FirstUniqueChar
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FirstUniqueChar {
    public static char findWord(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] ch = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : ch) {
            if (set.contains(c)) return c;
            set.add(c);
        }
        return ' ';
    }
}
