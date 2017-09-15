package wepay;

import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : NumberOfDistinctPalindrome
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class NumberOfDistinctPalindrome {
    //马拉车可以，可以dp，以后做了
    //Return the number of distinct palindromic substrings for a given string.
    HashSet<String> set = new HashSet<>();
    public int longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return set.size();
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        set.add(cur);
    }
}
