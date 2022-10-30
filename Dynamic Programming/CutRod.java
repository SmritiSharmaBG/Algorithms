public class Solution {
	public static int cutRod(int price[], int n) {
		// return rec(n - 1, price, n);
        
//         Integer[][] dp = new Integer[n][n + 1];
//         return memo(n - 1, price, n, dp);
        
        return dp(price, n);
	}
    
    // TABULATION
    private static int dp(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 1; i <= n; i ++) {
            dp[0][i] = i * price[0];    
        }
        for (int index = 1; index < n; index ++) {
            for (int len = 1; len <= n; len ++) {
                int notTake = 0 + dp[index - 1][len];
                int take = 0;
                int rodLength = index + 1;
                if (rodLength <= len) {
                    take = price[index] + dp[index][len - rodLength];
                }
                dp[index][len] = Math.max(take, notTake);
            }
        } 
        return dp[n - 1][n];
    }
    
    // MEMOIZATION
    private static int memo(int index, int price[], int n, Integer dp[][]) {
        if (n <= 0) return 0;
        if (index == 0) {
            return n * price[index];    
        }
        
        if (dp[index][n] != null) return dp[index][n];
        
        int notTake = 0 + memo(index - 1, price, n, dp);
        int take = 0;
        int rodLength = index + 1;
        if (rodLength <= n) {
            take = price[index] + memo(index, price, n - rodLength, dp);
        }
        
        return dp[index][n] = Math.max(take, notTake);
    }
    
    // RECURSIVE SOLUTION
    private static int rec(int index, int price[], int n) {
        if (n <= 0) return 0;
        if (index == 0) {
            return n * price[index];    
        }
        
        int notTake = 0 + rec(index - 1, price, n);
        int take = 0;
        int rodLength = index + 1;
        if (rodLength <= n) {
            take = price[index] + rec(index, price, n - rodLength);
        }
        
        return Math.max(take, notTake);
        
    }
}
