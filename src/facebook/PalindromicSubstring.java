package facebook;

/**
 * Created by Edward on 13/07/2017.
 */
public class PalindromicSubstring {

    static int min = 0;
    static int max = 0;

    /**
     * 5. Longest Palindromic Substring
     * worst case : Since expanding a palindrome around its center could take O(n)
     * time: O(n^2) space : O(1)
     * @param s
     * @return
     */

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i + 1);
            helper(s, i, i);
        }

        return s.substring(min, max + 1);
    }

    public static void helper(String s, int i, int j) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // j - i - 1 >= max - min + 1
        if (j - i - 1 > max - min) {
            min = i + 1;
            max = j - 1;
        }
    }

    public static int numberOfPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int res = 0;
        for (int i = 1; i <= length * 2 - 1; i++) {//i should start from 1 and end at length * 2 - 1
            int count = 1;//the center of the string should be counted as 1
            while (i - count >= 0 && i + count <= length * 2 && get(s, i - count) == get(s, i + count)) {
                count++;//boundary of i - count is 0, boundary of i + count is length * 2, which are all '#'
            }
            res += count / 2;//calculate how many palindromic substring that is formed by expanding from s.charAt(i)
        }
        return res;
    }

    private static char get(String s, int i) {
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(numberOfPalindrome(s));
    }
}
