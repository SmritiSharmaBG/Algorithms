
public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        
        // RECURSIVE SOLUTION
        // return rec(n - 1, denominations, value);
        
        // MEMOIZATION
        // Long[][] dp = new Long[n][value + 1];
        // return memo(n - 1, denominations, value, dp);
        
        // TABULATION
        return dp(n, denominations, value);
	}
    
    // TABULATION 
    private static long dp(int n, int denominations[], int value) {
        long[][] dp = new long[n][value + 1];
        // no of ways to make value = 0 : 1 : empty set {}
        for (int i = 0; i < n; i ++) dp[i][0] = 1l;
        for (int i = 1; i <= value; i ++) {
            if (i % denominations[0] == 0) dp[0][i] = 1l;
        }
        
        for (int index = 1; index < n; index ++) {
            for (int v = 1; v <= value; v ++) {
                long notTake = 0l;
                long take = 0l;

                notTake += dp[index - 1][v];
                if (denominations[index] <= v)
                take += dp[index][v - denominations[index]];

                dp[index][v] = take + notTake;        
            }
        }
        return dp[n - 1][value];
    }
    
    
    // MEMOIZATION
    private static long memo(int index, int denominations[], int value, Long[][] dp) {
        // base condition
        if (index == 0) {
            if (value % denominations[0] == 0) return 1;
            return 0l;
        }
        if (dp[index][value] != null) return dp[index][value];
        long notTake = 0l;
        long take = 0l;
        
        notTake += memo(index - 1, denominations, value, dp);
       
        if (denominations[index] <= value)
        take += memo(index, denominations, value - denominations[index], dp);
        
        return dp[index][value] = take + notTake;
    }
    
    // RECURSIVE SOLUTION
    private static long rec(int index, int denominations[], int value) {
        // base condition
        if (index == 0) {
            if (value % denominations[0] == 0) return 1;
            return 0l;
        }
        long notTake = 0l;
        long take = 0l;
        
        notTake += rec(index - 1, denominations, value);
       
        if (denominations[index] <= value)
        take += rec(index, denominations, value - denominations[index]);
        
        return take + notTake;
    }  	
}
