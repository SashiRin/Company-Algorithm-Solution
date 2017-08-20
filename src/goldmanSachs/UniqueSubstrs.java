package goldmanSachs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : UniqueSubstrs
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class UniqueSubstrs {
    /**
     * 不重复子串，输入是一个string和一个substr长度，返回所有unique substrs.
     *
     * @param s
     * @param substrs
     * @return
     */
    public static List<String> uniqueSubstrs(String s, int substrs) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - substrs; i++) {
            if (!set.contains(s.substring(i, i + substrs))) {
                set.add(s.substring(i, i + substrs));
            }
        }
        for (String str : set) {
            res.add(str);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = uniqueSubstrs("abcabc", 3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
