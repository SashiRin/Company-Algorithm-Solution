package wish;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wish
 * File Name : BuildAllofSubsequence
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BuildAllofSubsequence {

    /**
     * build subsequence: 返回一个string里面所有可能的subsequence
     * @param s
     * @return
     */

    public static String[] buildAllofSubsequence(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        for (char c : s.toCharArray()) {
            HashSet<String> set = new HashSet<>();
            for (String temp : res) {
                set.add(temp + c);
            }
            res.addAll(set);
        }
        String[] ret = new String[res.size() - 1];
        int k = 0;
        for (int i = 1; i < res.size(); i++) {
            ret[k++] = res.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] res = buildAllofSubsequence(s);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
