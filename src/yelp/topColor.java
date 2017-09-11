package yelp;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : yelp
 * File Name : topColor
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class topColor {
    /**
     * 题目： 就是给一组String[]  , 返回在里边出现次数最多的string (细节有点忘记了） 大概就是.
     * for example: { "red", "black","green"  "white", "red", "black". "black", "red" }
     *  return "red", "black"  { "red", "black","green"  "white", "red", "black" "black", "red" "green", "red" }   
     * return "red"

     * @param colors
     * @return
     */
    private static List<String> topColor(List<List<String>> colors){
        List<String> res = new ArrayList<>();
        int max = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < colors.size(); i++) {
            for (int j = 0; j < colors.get(i).size(); j++) {
                String cur = colors.get(i).get(j);
                if (map.containsKey(cur)) {
                    map.put(cur, 1);
                    max = Math.max(max, 1);
                } else {
                    map.put(cur, map.get(cur) + 1);
                    max = Math.max(max, map.get(cur) + 1);
                }
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                res.add(entry.getKey());
            }
        }
        Collections.sort(res, new Comparator<String>(){
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> colors = new ArrayList<>();
        List<String> color1 = new ArrayList<>();
        List<String> color2 = new ArrayList<>();
        List<String> color3 = new ArrayList<>();
        color1.add("red");
        color1.add("black");
        color1.add("green");
        color2.add("white");
        color2.add("red");
        color2.add("black");
        color3.add("black");
        color3.add("red");
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        System.out.println(topColor(colors));
    }
}
