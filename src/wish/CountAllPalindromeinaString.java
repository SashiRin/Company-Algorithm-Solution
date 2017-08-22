package wish;

import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wish
 * File Name : CountAllPalindromeinaString
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class CountAllPalindromeinaString {

    /**
     * count palindromes: 计算一个string里的palindromes
     * (一个test case没过)
     * @param s
     * @param start
     * @param end
     * @return
     */

    public static boolean isPalindrome(String s, int start, int end){
        if (start == end) {
            return true;
        }
        for (int i = 0; i <= (end - start) / 2; i++) {
            if (s.charAt(i + start) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public static int countNumPalindromes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (isPalindrome(s, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome2(String s, int start, int end, HashSet<String> set){
        if (start == end) {
            return true;
        }
        for (int i = 0; i <= (end - start) / 2; i++) {
            if (s.charAt(i + start) != s.charAt(end - i)) {
                return false;
            }
        }
        String palin = s.substring(start, end + 1);
        if (set.contains(palin)) {
            System.out.println(palin);
            return false;
        } else set.add(palin);
        return true;
    }

    public static int countNumPalindromes2(String s) {  //去掉所有重复
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (isPalindrome2(s, i, j, set)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abaaba";
        System.out.println(countNumPalindromes2(s));
    }
}
