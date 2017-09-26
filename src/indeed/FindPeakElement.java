package indeed;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FindPeakElement
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindPeakElement {

    /**
     给一个数组，例如[8,5,3,6,1,4,7], 返回任意一个local minimum，也就是任意一个谷值，比如在这个例子里，返回3和1都是正确的。
     数组没有重复的数，所以不会出现[1,1,1,1,1]这种没有结果的情况情况。

     楼主先用了一个O(n)的方法，很快写完。然后楼主感觉是可以用二分法的，但是12月过后圣诞太久没刷题了竟然蒙蔽了没写出来。。。。尴尬。
     后面基本上是靠面试官提醒才想出来，可是时间不够了没写就结束了。
     这题的corner case也要注意，比如说一头一尾也会出现谷值，比如只有一个数字可以直接返回。

     time : O(logn);
     space : O(1);
     * @param nums
     * @return
     */

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] > nums[end]) return nums[start];
        return nums[end];
    }

    public static int find(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
    public static void main(String[] args) {
        int[] nums = {8, 5, 3, 6, 1, 4, 7};
        int[] n = {1,8,7,5,3};
        System.out.println(find(n));
    }
}
