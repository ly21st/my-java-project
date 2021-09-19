package leetcode.dongtaiguihua;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-24
 **/
public class Rob2 {
    // [2,1,1,2]
    public int rob(int[] nums) {
        // 定义dp[i] 到i房间为止，最大的盗窃金额
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        if (n < 2) {
            return nums[0];
        }
        int []dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2;  i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}