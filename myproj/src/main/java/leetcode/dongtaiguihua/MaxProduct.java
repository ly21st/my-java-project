package leetcode.dongtaiguihua;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-23
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int []dpMin = new int[n];
        int []dpMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dpMax[i] = nums[i];
                dpMin[i] = nums[i];
                continue;
            }
            int s1 = dpMax[i-1] * nums[i];
            int s2 = dpMin[i-1] * nums[i];
            dpMax[i] = Math.max(Math.max(s1, s2), nums[i]);
            dpMin[i] = Math.min(Math.min(s1, s2), nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < dpMax[i]) {
                max = dpMax[i];
            }
        }
        return max;
    }
}
