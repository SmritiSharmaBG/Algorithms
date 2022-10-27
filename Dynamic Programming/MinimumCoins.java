import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        if (n == 0) return -1;
        // RECURSION
//         int ans = rec(n - 1, x, num);
//         if (ans >= 1e9) return -1;
//         return ans;
        
        // MEMOIZATION
//         Integer[][] dp = new Integer[n][x + 1];
//         int ans = memo(n - 1, x, num, dp);
//         if (ans >= 1e9) return -1;
//         return ans;
        
        // TABULATION
        return dp(num, x, n);
    }
    
    // TABULATION
    private static int dp(int[] num, int x, int n) {
        if (x == 0) {
            return 0;
        }
        
        int[][] dp = new int[n][x + 1];
        
        for (int i = 1; i <= x; i ++) {
            if (i % num[0] == 0)
                dp[0][i] = i / num[0];
             else dp[0][i] = (int)1e9;
        }  
        
        for (int index = 1; index < n; index ++) {
            for (int target = 1; target <= x; target ++) {
                int take = Integer.MAX_VALUE;
                int notTake = 0;               

                notTake = 0 + dp[index - 1][target];

                if (num[index] <= target) take = 1 + dp[index][target - num[index]];

                dp[index][target] = Math.min(notTake, take);        
            }
        }
        int ans = dp[n - 1][x];
        if (ans >= 1e9) return -1;
        return ans;
    }
    // MEMOIZATION
    private static int memo(int index, int target, int[] num, Integer[][] dp) {
        if (target == 0) {
            return 0;
        }
        
        if (index == 0) {
            if (target % num[0] == 0)
                return target / num[0];
             return (int)1e9;
        }    
        
        if (dp[index][target] != null) return dp[index][target];
        
        int take = Integer.MAX_VALUE;
        int notTake = 0;               
        
        notTake = 0 + memo(index - 1, target, num, dp);
        
        if (num[index] <= target) take = 1 + memo(index, target - num[index], num, dp);
        
        return dp[index][target] = Math.min(notTake, take);
    }
    
    // RECURSIVE SOLUTION
    private static int rec(int index, int target, int[] num) {
        if (target == 0) {
            return 0;
        }
        
        if (index == 0) {
            if (target % num[0] == 0)
                return target / num[0];
             return (int)1e9;
        }        
        int take = Integer.MAX_VALUE;
        int notTake = 0;               
        
        notTake = 0 + rec (index - 1, target, num);
        
        if (num[index] <= target) take = 1 + rec(index, target - num[index], num);
        
        return Math.min(notTake, take);
    }

}
