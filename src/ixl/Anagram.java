package ixl;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : ixl
 * File Name : Anagram
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Anagram {

    /**
     * OA question 2
     * @param a
     * @param b
     * @return
     */
    public static int[] getMinimumDifference(String[] a, String[] b){
        if (a.length != b.length) return new int[]{};
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                res[i] = -1;
            } else {
                int[] count = new int[26];
                for (int j = 0; j < a[i].length(); j++) {
                    count[a[i].charAt(j) - 'a']++;
                    count[b[i].charAt(j) - 'a']--;
                }
                for (int j = 0; j < count.length; j++) {
                    if (count[j] > 0) {
                        res[i] += count[j];
                    }
                }
            }
        }
        return res;
    }
}
