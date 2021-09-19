package leetcode.dongtaiguihua;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-23
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //  定义dp[i]为以索引i结尾的最大连续子序列和
        // dp[i] = dp[i-1]+nums[i] ,dp[i-1]>=0
        // dp[i] = nums[i], dp[i-1] < 0
        int []dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                continue;
            }
            if (dp[i-1] >= 0) {
                dp[i] += dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
