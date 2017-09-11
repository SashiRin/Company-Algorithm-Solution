package houzz;

/**
 * Project Nje : Company Algorithm Solution
 * Package Nje : houzz
 * File Nje : CoinChange
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class CoinChange {
    public int coinChange(int[] coins, int target) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (target <= 0) return 0;
        int[] dp = new int[target + 1];
        for (int i = 1;i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int j = 1; j <= target; j++) {  //j代表当前钱数
            for (int i = 0; i < coins.length; i++) { //i代表用了那些硬币
                if (coins[i] <= j) {  //大于的话是代表不了的
                    int diff = j - coins[i];
                    if (dp[diff] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[diff] + 1, dp[j]);//需要把所有的硬币都试一遍
                    }
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}
