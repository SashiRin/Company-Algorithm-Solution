package houzz;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : KthMinInSortedArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class KthMinInSortedArray {
    /*
    给两个sorted array求出第k个最小值
     */
    public static int findKthLargest(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k < 1) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < nums1.length && j < nums2.length) {
            k--;
            if (nums1[i] < nums2[j]) {
                res = nums1[i];
                i++;
            } else {
                res = nums2[j];
                j++;
            }
            if (k == 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,7,10};
        int[] nums2 = {1,6,9,11};
        System.out.println(findKthLargest(nums1, nums2, 3));
    }
}
