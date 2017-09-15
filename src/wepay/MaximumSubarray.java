package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : MaximumSubarray
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MaximumSubarray {
    //Max subarray 只是subarray size必须大于2 以后写
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int maxSubArray2(int[] nums) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<nums.length;++i){
            if(sum<0)
                sum=nums[i];
            else
                sum=sum+nums[i];
            if(sum>max)
                max=sum;
        }
        return max;
    }
}
