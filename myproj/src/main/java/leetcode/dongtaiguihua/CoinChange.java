package leetcode.dongtaiguihua;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-23
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int coinsLen = coins.length;
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        // dp[amount] = min(dp[amount-coins[0]]，dp[amount-coins[1]) + 1
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coinsLen; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] >= 0) {
                    }
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }
}
