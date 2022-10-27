import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // RECURSIVE APPROACH
        // return rec(n - 1, weight, value, maxWeight);
        
        // MEMOIZATION
        // Integer[][] dp = new Integer[n][maxWeight + 1];
        // return memo(n - 1, weight, value, maxWeight, dp);
        
      // TABULATION  
      return dp(weight, value, n, maxWeight);
    }
    
    // TABULATION
    private static int dp(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
      
        for (int w = weight[0]; w <= maxWeight; w ++) dp[0][w] = value[0];        
        
        for (int index = 1; index < n; index ++) {
            for (int w = 1; w <= maxWeight; w ++) {
                int notTake = 0;
                int take = 0;

                // notTake
                notTake = 0 + dp[index - 1][w];

                // take
                if (weight[index] <= w) 
                    take = value[index] + dp[index - 1][w - weight[index]];

                dp[index][w] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][maxWeight];
    }
    
    // RECURSIVE APPROACH
    private static int rec(int index, int[] weight, int[] value, int maxWeight) {
        if (index == 0) {
            int notTake = 0;
            int take = 0;
            if (weight[0] <= maxWeight) take = value[0];
            return Math.max(notTake, take);
        }
        int notTake = 0;
        int take = 0;
        
        // notTake
        notTake = 0 + rec(index - 1, weight, value, maxWeight);
        
        // take
        if (weight[index] <= maxWeight) take = value[index] + rec(index - 1, weight, value, maxWeight - weight[index]);
        
        return Math.max(notTake, take);
    }
    
    // MEMOIZATION
    private static int memo(int index, int[] weight, int[] value, int maxWeight, Integer[][] dp) {
        if (index == 0) {
            int notTake = 0;
            int take = 0;
            if (weight[0] <= maxWeight) take = value[0];
            return Math.max(notTake, take);
        }
        
        if (dp[index][maxWeight] != null) return dp[index][maxWeight];
        int notTake = 0;
        int take = 0;
        
        // notTake
        notTake = 0 + memo(index - 1, weight, value, maxWeight, dp);
        
        // take
        if (weight[index] <= maxWeight) take = value[index] + memo(index - 1, weight, value, maxWeight - weight[index], dp);
        
        return dp[index][maxWeight] = Math.max(notTake, take);
    }
}
