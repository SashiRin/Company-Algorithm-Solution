package indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : WordsBeforeIndexK
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class WordsBeforeIndexK {
    /**
     * In a string, find all words before index k. Words are separated by space
     "abc def gh i"
     if k = 5, return ["abc"]
     if k = 9, return ["abc", "def"]

     */
    public static List<String> words(String s, int k) {
        List<String> res = new ArrayList<>();
        String[] strs = s.split(" ");
        for (String str : strs) {
            if (k >= str.length()) {
                res.add(str);
                k -= (str.length() + 1);  //空格+1
            } else break;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc def gh i";
        List<String> res = words(s, 10);
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
}
