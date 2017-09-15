package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : AverageArray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class AverageArray {
    //可以维护一个cnt记录当前数据的个数，evr记录当前的平均值
    //然后每增减一个新数据val时，更新这个cnt和evr的值即可
    /*
        设x为已有数据的平均数，n为已有数据的个数，新的数据为y
    那么就是
    (x * n + y)/(n+1) =( x * (n+1)  - x + y )/(n+1) = x + (y-x)/(n+1);

    x + (y-x)/(n+1);这样就简单了。用double 应该问题不大。
     */
    public static double average(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        double res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res / nums.length;
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{1,2,3,4,5}));
    }
}
