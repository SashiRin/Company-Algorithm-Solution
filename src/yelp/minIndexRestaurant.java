package yelp;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : yelp
 * File Name : minIndexRestaurant
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class minIndexRestaurant {

    public static String Restaurant(List<String> l1, List<String> l2) {
        String res = "yelpwich";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l1.size(); i++) {
            map.put(l1.get(i), i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l2.size(); i++) {
            Integer index = map.get(l2.get(i));
            if (index != null) {
                if (index + i < min) {
                    min = index + i;
                    res = l2.get(i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.addAll(Arrays.asList("ab", "barr", "bar", "foo" ,"bar"));
        list2.addAll(Arrays.asList("bar", "foo"));
        System.out.println(Restaurant(list1, list2));
    }
}
