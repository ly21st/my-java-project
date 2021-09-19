package leetcode.bingchaji;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-29
 **/
public class NumIslands {
    class UnionFound {
        private int count;
        private int []parent;
        private int []size;
        public UnionFound(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int []parent, int p) {
             while (p != parent[p]) {
                 parent[p] = parent[parent[p]];
                 p = parent[p];
             }
             return p;
        }

       public void union(int p, int q) {
            int setp =  find(parent, p);
            int setq = find(parent, q);
            if (setp == setq) {
                return;
            }
            count--;
            if (size[setp] < size[setq]) {
                parent[setp] = setq;
                size[setq] += size[setp];
            } else {
                parent[setq] = setp;
                size[setq] += size[setp];
            }
       }

       public int count() {
            return count;
       }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        if (n < 1) {
            return 0;
        }
        UnionFound uf = new UnionFound(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int p = i * n + j;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(p, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(p, i * n + j - 1);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(p, (i + 1) * n + j);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.union(p, i * n + j + 1);
                    }
                }
            }
        }
        return uf.count();
    }
}
