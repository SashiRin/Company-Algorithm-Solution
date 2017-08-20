package goldmanSachs;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : ClimbingStairs
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class ClimbingStairs {
    /**
     * 爬楼梯是1， 2， 3 steps
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
