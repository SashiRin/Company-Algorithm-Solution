import houzz.TreeNode;

import java.util.*;

import static indeed.TiltBinaryTree.tilt;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : PACKAGE_NAME
 * File Name : Test
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Test {
    public static List<String> so(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        int start = 0;
        while(start < nums.length) {
            int j = binarySearch(nums, start, nums.length);
            String s = String.valueOf(nums[start]);
            String e = String.valueOf(nums[j]);
            if(s.equals(e)) {
                list.add(e);
            } else {
                list.add(s + "->" + e);
            }
            start = j + 1;
        }
        return list;
    }
    public static int binarySearch(int[] nums, int start, int end) {
        int l = start, r = end;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] - nums[l] > mid - l) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] test2 = {1,2,3,4,5,6,7,8,9,10,12,13,16};

        List<String> res = so(test2);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
