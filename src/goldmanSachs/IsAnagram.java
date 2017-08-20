package goldmanSachs;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : IsAnagram
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class IsAnagram {
    /**
     * isAnagram
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int)s.charAt(i)]++;
            count[(int)t.charAt(i)]--;
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "123dfsf*^^@";
        String t = "123dfqf*^^@";
        System.out.println(isAnagram(s, t));
    }
}
