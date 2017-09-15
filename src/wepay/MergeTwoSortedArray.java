package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : MergeTwoSortedArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
