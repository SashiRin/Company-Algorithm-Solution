package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : PalindromePermutation
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
