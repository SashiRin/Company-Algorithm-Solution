package indeed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : UnionOfTwoSortedArrays
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MergeUnionOfTwoSortedArrays {
    /**
     * e.g. int[] a = {1,2,3,4};
     int[] b = {2,4,5};
     返回 {1，2，3，4，5}
     */

    public static int[] merge(int[] nums1, int[] nums2) {

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res.add(nums1[i++]);
            } else if (nums1[i] > nums2[j]){
                res.add(nums2[j++]);
            } else {  // 相等
                res.add(nums1[i++]);
                j++;
            }
        }
        while (i < nums1.length) {
            res.add(nums1[i++]);
        }
        while (j < nums2.length) {
            res.add(nums2[j++]);
        }
        int[] ret = new int[res.size()];
        for (int k = 0; k < ret.length; k++) {
            ret[k] = res.get(k);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 5, 7};
        int[] nums2 = {2, 3, 5, 6};
        System.out.println(Arrays.toString(merge(nums1, nums2)));
    }
}
