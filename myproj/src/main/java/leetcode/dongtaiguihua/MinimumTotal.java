package leetcode.dongtaiguihua;

import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-23
 **/
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int []dp = new int[n];
        if (n == 0) {
            return 0;
        }
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + rows.get(j);
                } else if (j == i) {
                    dp[j] = dp[j-1] + rows.get(j);
                }
                else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + rows.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min < dp[i]) {
                min = dp[i];
            }
        }
        return min;
    }
}
