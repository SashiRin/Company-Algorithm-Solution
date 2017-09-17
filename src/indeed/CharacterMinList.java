package indeed;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : CharacterMinList
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class CharacterMinList {
    /**
     * 给一个list， 如何把里面的字符分配到尽量少的子list里，并且每个子list没有重复元素。
     比如
     ['a','b','c','a','a','b']， 可以分成['a', 'b', 'c'], ['a', 'b'], ['a']
     ['a', 'a', 'a', 'b', 'b', 'b']，可以分成['a', 'b'], ['a', 'b'], ['a', 'b']

     time : O(n)
     */

    public static List<char[]> minList(char[] arr) {
        List<char[]> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                max = Math.max(max, map.get(c));
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < max; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char c = entry.getKey();
                if (map.get(c) > 0) {
                    list.add(c);
                    map.put(c, map.get(c) - 1);
                }
            }
            char[] array = new char[list.size()];
            for (int k = 0; k < list.size(); k++) {
                array[k] = list.get(k);
            }
            res.add(array);
        }
        return res;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'a', 'a', 'b', 'b', 'b'};
        List<char[]> list = minList(arr);
        for (char[] c : list) {
            System.out.println(Arrays.toString(c));
        }
    }
}
