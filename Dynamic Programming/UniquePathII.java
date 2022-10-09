import java.util.*;
public class Solution {
    private static final int N = 1000000007;
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        Integer[][] dp = new Integer[n][m];
        return rec(0, 0, n, m, mat, dp) % N;
    }
    
    private static int rec(int i, int j, int n, int m, ArrayList<ArrayList<Integer>> mat, Integer[][] dp) {
        if(i == n - 1 && j == m - 1) return 1;
        
        if (dp[i][j] != null) return dp[i][j];
        
        int right = 0;
        int down = 0;
        
        // move right j + 1
        if(j + 1 < m && i < n) {
            int o = mat.get(i).get(j + 1);
            if(o != -1) right = rec(i, j + 1, n, m, mat, dp);
            right = right % N;
        }
        
        // move down i + 1
        if(j < m && i + 1 < n) {
            int o = mat.get(i + 1).get(j);
            if(o != -1) down = rec(i + 1, j, n, m, mat, dp);
            down = down % N;
        }
        
        return dp[i][j] = right + down;
    }
}
