package wepay;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : EnglishNameNick
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class EnglishNameNick {
    /*
    给一个map，map是英文名字和对应的昵称。写一个函数，把一个句子（String）中在map中出现过的名字替换成对应的昵称。
     */
    public static String name(String s, HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (i + entry.getKey().length() <= s.length()) {
                    if (s.substring(i, i + entry.getKey().length()).equals(entry.getKey())) {
                        sb.append(entry.getValue());
                        i = i + entry.getKey().length();
                        continue;
                    }
                }
            }
            if (i < s.length()) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ed  wac#$rdsam";
        HashMap<String, String> map = new HashMap<>();
        map.put(new String("sam"), new String("lucy"));
        System.out.println(name(s, map));
    }
}
