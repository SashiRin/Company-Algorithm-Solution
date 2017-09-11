import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : PACKAGE_NAME
 * File Name : BuildSubsequence
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BuildSubsequence {
    public static String buildSubsequence(String s, int n) {
        List<String> res = new ArrayList<>();
        res.add("");
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            HashSet<String> set = new HashSet<>();
            for (String temp : res) {
                set.add(temp + c);
                if (map.containsKey(temp + c)) {
                    map.put(temp + c, map.get(temp + c) + 1);
                } else {
                    map.put(temp + c, 1);
                }
            }
            res.addAll(set);
        }
        String ret = "";
        int freq = 0;
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            if (temp.getKey().length() == n) {
                if (freq < temp.getValue()) {
                    ret = temp.getKey();
                    freq = temp.getValue();
                }
            }
        }
        return ret;
    }

    public static String build(String s, int n) {
        if(n>s.length()|| n==0) return "";
        if(n==s.length()) return s;
        char[] sc = s.toCharArray();

        int[][] dpCount = new int[n+1][s.length()+1];
        String[][] dpString = new String[n+1][s.length()+1];
        for(int i = 0; i<=s.length(); ++i){
            dpCount[0][i] = 1;
            dpString[0][i] = "";
        }
        for(int len = 1; len<=n; ++len){
            // This two arrays stores previous MCS with len ending with specific char
            int[] endWithCount = new int[26];
            String[] endWithString = new String[26];

            int maxCount = 0, maxCountChar = -1;
            for(int idx = len; idx<=s.length(); ++idx){
                int curChar = sc[idx-1]-'a';
                // For MCS ending with curChar, there are 2 options
                // 1. MCS of (len-1, idx-1) + curChar
                // 2. MCS of (len, idx-1) ending with curChar
                // Notice, for the 2nd option, counter will plus 1 since duplicate
                if(dpCount[len-1][idx-1]>endWithCount[curChar]){
                    // Choose 1st option, and updating the arrays
                    endWithCount[curChar] = dpCount[len-1][idx-1];
                    endWithString[curChar] = dpString[len-1][idx-1]+sc[idx-1];
                }
                else{
                    // Choose 2nd option, and counter plus 1 due to duplication
                    ++endWithCount[curChar];
                }

                //Update current max, and this will be the ans for MCS (len, idx)

                if(endWithCount[curChar]>maxCount){
                    maxCount = endWithCount[curChar];
                    maxCountChar = curChar;
                }
                dpCount[len][idx] = maxCount;
                dpString[len][idx] = endWithString[maxCountChar];
            }
        }
        System.out.println(dpCount[n][s.length()]);
        return dpString[n][s.length()];
    }

    public static void main(String[] args) {
        String s = "dogcatchcat";
        String res = buildSubsequence(s, 3);
        String res2 = build(s,3);
        System.out.println(res);
        System.out.println(res2);
    }
}
