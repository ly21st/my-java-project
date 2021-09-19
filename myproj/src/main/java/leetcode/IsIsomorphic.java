package leetcode;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-19
 **/
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] m = new int[256];
        int[] visited = new int[256];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m[c1] == 0) {
                if (visited[c2] != 0) {
                    return false;
                }
                m[c1] = c2;
                visited[c2]++;
            } else {
                char c = (char)m[c1];
                if (c!= c2) {
                    return false;
                }
            }
        }
        return true;
    }
}
