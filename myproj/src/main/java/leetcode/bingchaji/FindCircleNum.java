package leetcode.bingchaji;

public class FindCircleNum {
    int count = 0;
    public int findCircleNum(int[][] M) {
        int m = M.length;
        if (m < 1) {
            return 0;
        }
        int n = M[0].length;
        if (n < 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    circleNumCount(M, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void circleNumCount(int[][]M, int m, int n, int i, int j) {
        M[i][j] = 0;
        M[j][i] = 0;
        M[i][i] = 0;
        M[j][j] = 0;
        for (int k = 0; k < m; k++) {
            if (M[i][k] == 1) {
                M[i][k] = 0;
                circleNumCount(M, m, n, i, k);
            }
        }
        for (int k = 0; k < n; k++) {
            if (M[j][k] == 1) {
                M[j][k] = 0;
                circleNumCount(M, m, n, j, k);
            }
        }
    }
}
