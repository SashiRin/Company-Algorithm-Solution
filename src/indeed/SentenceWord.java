package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : SentenceWord
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SentenceWord {
    /**
     * 给一个sentence，包含很多的word，然后让找到第一个重复的单词
     "hello world world hello"
     返回 world

     然后说改改看，返回重复单词中，第一个出现的
     "hello world world hello"
     返回 hello

     follow up如果这是一个real word的function怎么办，比如说你的输入是一本杂志里面的词，找出所有duplicate的词。
     这里的意思是，真实中的输入不一定严格的以一个空格隔开每个单词（不能简单用split(“ ”))，不一定全部小写等等
     lz答首先处理成全部小写，然后把单词分隔开，可以用trie来省内存（要是内存放不下还可以放进disk），
     然后说了一下因为现实中有些词出现次数很多但是没什么意义的，比如I, you, he, she这些，
     可以另外设置一个filter来把这些不valuable的输出过滤掉（小哥表示赞同），最后又补充了可以多台机器一起做。
     */
    public static String findWord(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strs = s.split("\\s+");
        HashSet<String> set = new HashSet<>();
        for (String str : strs) {
            if (set.contains(str)) return str;
            set.add(str);
        }
        return "";
    }
    public static String findWord2(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strs = s.split("\\s+");
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        String res = "";
        int num = Integer.MAX_VALUE;
        for (String str : strs) {
            if (set.contains(str)) {
                if (map.get(str) < num) {
                    num = map.get(str);
                    res = str;
                }
            } else {
                set.add(str);
                map.put(str, index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "hello world world hello";
        System.out.println(findWord(s));
        System.out.println(findWord2(s));
    }
}
