package houzz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : FrequentHashMap
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FrequentHashMap {
    /*
    输入hashtable{"a"=>50, "b"=>25, "c"=25}, 要求每次call这个function，print概率按照输入hashtable里面概率.
    所以有50%的概率print a, 25% b, 25% c
     */
    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (target == arr[mid]) return mid;
            else if (target < arr[mid]) end = mid;
            else start = mid;
        }
        if (target <= arr[start]) {
            return start;
        } else if (target <= arr[end]) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static void Frequent(HashMap<String, Integer> map) {
        int[] arr = new int[map.size()];
        String[] s = new String[map.size()];
        int j = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[j] = entry.getValue();
            s[j++] = entry.getKey();
        }
        for (int i = 1; i < arr.length; i++) arr[i] += arr[i - 1];
        Random rm = new Random();
        int target = rm.nextInt(arr[arr.length - 1]);
        System.out.println(target);
        int res = binarySearch(arr, target);
        System.out.println(s[res]);
    }

    public static void main(String[] args) {
        int[] arr = {25, 25, 50};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 25);
        map.put("b", 25);
        map.put("c", 50);
        Frequent(map);
    }
}