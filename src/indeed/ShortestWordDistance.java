package indeed;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : ShortestWordDistance
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ShortestWordDistance {
    /**
     * Interviewees said this question(and follow up) is the same as Leetcode 243，244，245
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }

    /**
     * call 多次
     */
    private HashMap<String, List<Integer>> map;

    public ShortestWordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    //time : O(n * m)
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    /**
     * 有两个一样   245
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance3(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    a = b;
                }
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }

    /**
     * 就是给你一段String[] = {"we all love indeed, and everyone use python and nobody like java,
     * but we would hire java developer"};
     让你return result = and everyone use python and nobody like java, but we would.这道不难，就维护两个指针 pre and post.
     把这段话分成3段存入result =[pre-3 to pre]+ python ==== java + [post to post +3].
     前面3个，后面三个
     * @param s
     * @return
     */
    public static String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int a = -1, b = -1;
        int l = -1, r = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.charAt(str.length() - 1) == ',') {
                str = str.substring(0, str.length() - 1);
            }

            if (str.equals("java")) {
                l = i;
            } else if (str.equals("python")) {
                r = i;
            }
            if (l != -1 && r != -1) {
                if (Math.abs(l - r) < min) {
                    min = Math.abs(l - r);
                    a = l; b = r;
                }

            }
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(b);
        int start = -1, end = -1;
        if (a - 3 < 0) {
            start = 0;
        } else start = a - 3;

        if (b + 3 >= strs.length) {
            end = strs.length - 1;
        } else end = b + 3;
        System.out.println(end);
        while (start <= end) {
            sb.append(strs[start++] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "we all love indeed, and everyone use python and nobody like java, but we would hire java developer";
        System.out.println(reverse(s));
    }
}
