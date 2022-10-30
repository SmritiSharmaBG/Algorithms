import java.util.* ;
import java.io.*; 
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // return rec(n - 1, n, w, profit, weight);
        
//         Integer[][] dp = new Integer[n][w + 1];
//         return memo(n - 1, w, profit, weight, dp);
        
        return dp(n, w, profit, weight);
    }
    
    // TABULATION
    private static int dp(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int i = 1; i <= w; i ++) {
            if (i >= weight[0]) {
                int x = i / weight[0];
                dp[0][i] = x * profit[0];
            } 
            else dp[0][i] = 0;
        }
        
        for (int index = 1; index < n; index ++) {
            for (int wt = 1; wt <= w; wt ++) {
                int notTake = dp[index - 1][wt];
                int take = 0;
                
                if (weight[index] <= wt)
                take = profit[index] + dp[index][wt - weight[index]];

                dp[index][wt] = Math.max(notTake, take);        
            }
        }
        
        return dp[n - 1][w];
    }
    
    // MEMOIZATION
    private static int memo(int index, int w, int[] profit, int[] weight, Integer[][] dp) {
        if (index == 0) {
            if (w >= weight[0]) {
                int x = w / weight[0];
                return x * profit[0];
            } 
            return 0;
        }
        
        if (dp[index][w] != null) return dp[index][w];
        
        int notTake = 0 + memo(index - 1, w, profit, weight, dp);
        int take = 0;
        if (weight[index] <= w)
        take = profit[index] + memo(index, w - weight[index], profit, weight, dp);
        
        return dp[index][w] = Math.max(notTake, take);
    }
    // RECURSIVE SOLUTION
    private static int rec(int index, int n, int w, int[] profit, int[] weight) {
        if (index == 0) {
            if (w >= weight[0]) {
                int x = w / weight[0];
                return x * profit[0];
            } 
            return 0;
        }
        int notTake = 0 + rec(index - 1, n, w, profit, weight);
        int take = 0;
        if (weight[index] <= w)
        take = profit[index] + rec(index, n, w - weight[index], profit, weight);
        
        return Math.max(notTake, take);
    }
}
