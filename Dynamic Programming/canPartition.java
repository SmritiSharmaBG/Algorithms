public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return dp(arr, n, target);
	}
    
    // RECURSIVE SOLUTION
    private static boolean recursive(int index, int[] arr, int n, int target) {
        if (arr[index] == target) return true;
        if (index == 0) {
            if (arr[0] == target) return true;
            return false;
        }
        // take
        boolean take = false;
        if (arr[index] <= target) take = recursive(index - 1, arr, n, target - arr[index]);
        
        boolean notTake = recursive(index - 1, arr, n, target);
        
        return take || notTake;
    }
    
    // BOTTOM UP SOLUTION
    private static boolean rec(int index, int[] arr, int n, int target, Boolean[][] dp) {
        if (arr[index] == target) return true;
        if (index == 0) {
            if (arr[0] == target) return true;
            return false;
        }
        if (dp[index][target] != null) return dp[index][target];
        // take
        boolean take = false;
        if (arr[index] <= target) take = rec(index - 1, arr, n, target - arr[index], dp);
        
        boolean notTake = rec(index - 1, arr, n, target, dp);
        
        return dp[index][target] = take || notTake;
    }
    
    // TOP DOWN SOLUTION
    private static boolean dp(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][arr[0]] = true;
        for(int i = 0; i < n; i ++) dp[i][0] = true;
        
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j <= target; j ++) {
                boolean take = false;
                if (arr[i] <= j) take = dp[i - 1][j - arr[i]];

                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake; 
            }
        }
        return dp[n - 1][target];
    } 
}
