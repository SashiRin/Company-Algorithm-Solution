package houzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : KSum
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class KSum {

    //boolean flag = false;
    public static List<List<Integer>> kSum(int[] nums, int k, int target) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, k, target, 0);
        //如果返回类型为boolean：有一个全局变量flag
        // if (flag) return true; return false;
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int target, int start) {
        if (k < 0) return;
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, k - 1, target - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
    /*  返回类型为boolean
    private void helper(int num[], int k, int target, int pos, int count) {
        if( count > k ) return;
        if( count == k ){
            if( target == 0 ){
                flag = true;
            }
            return;
        }
        for( int i = pos ; i < num.length; i ++){
            helper(num,k,target-num[pos],i,count+1);
        }

    }*/

    /*
    Given n distinct positive integers, integer k (k <= n) and a number target.

    Find k numbers where sum is target. Calculate how many solutions there are?
    * DP
    * ksum[i][j][l]表示前j个元素里面取l个元素之和为i。
    * 初始化：ksum[0][j][0] =1(j:0~n)，即前j个元素里面取0个元素使其和为0的方法只有1种，那就是什么都不取
    * ksum[i][j][l] = ksum[i][j-1][l] + ksum[i-A[i-1]][j-1][l-1]
    * i : sum, j is first j element, l elements that is used to calculate sum
    * 即前j个元素里面取l个元素之和为i由两种情况组成：第一种情况为不包含第i个元素，即前j－1个元素里取l个元素使其和为i，
    * 第二种情况为包含第i个元素，即前j－1个元素里取l－1个元素使其和为i-A[i-1]（前提是i-A[i-1]>=0）
    1,2,3  k = 2  target = 3

    res[0][0][0] = 1

    res[0][1][0] = 1

    res[0][2][0] = 1

    res[0][3][0] = 1
    */
    public int  kSum1(int nums[], int k, int target) {
        // write your code here
        if (target < 0) {
            return 0;
        }
        int len = nums.length;
        int[][][] D = new int[len + 1][k + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                for (int t = 0; t <= target; t++) {
                    if (j == 0 && t == 0) {
                        // select 0 number from i to the target: 0
                        D[i][j][t] = 1;
                    } else if (!(i == 0 || j == 0 || t == 0)) {
                        D[i][j][t] = D[i - 1][j][t];
                        if (t - nums[i - 1] >= 0) {
                            D[i][j][t] += D[i - 1][j - 1][t - nums[i - 1]];
                        }
                    }
                }
            }
        }
        return D[len][k][target];
    }



    public static void main(String[] args) {
        int[] test = new int[]{1,2,-3,4,5};
        List<List<Integer>> res = kSum(test, 3, 0);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.println(num);
            }
        }
    }

}
