class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        //return rec(0, arr, n - 1);
        
        // int[] dp = new int[n];
        // for (int i = 0; i < n; i ++) dp[i] = -1;
        // return recDP(0, arr, n - 1, dp);
        
        //return dp(arr, n);
        
        return fun(arr, n);
    }
    
    // best solution
    private int fun(int[] arr, int n) {
        int prev2 = 0;
        int prev1 = arr[0];
        int curr;
        
        for(int i = 1; i < n; i ++) {
            int pick = arr[i] + prev2; 
            int notPick = 0 + prev1;
            curr = pick > notPick ? pick : notPick;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    // TABULATION METHOD
    private int dp(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        
        for(int i = 1; i < n; i ++) {
            int pick = arr[i]; 
            if((i - 2) >= 0) pick += dp[i - 2];
            int notPick = 0;
            if((i - 1) >= 0) notPick += dp[i - 1];
            dp[i] = pick > notPick ? pick : notPick;
        }
        
        return dp[n - 1];
    }
    
    // RECURSION WITH DP ARRAY
    private int recDP(int index, int[] arr, int n, int[] dp) {
        if (index > n) return 0;
        if (index == n) return arr[index];
        
        if(dp[index] != -1) return dp[index];
        
        int pick = arr[index] + recDP(index + 2, arr, n, dp);
        int notPick = recDP(index + 1, arr, n, dp);
        
        dp[index] = pick > notPick ? pick : notPick;
        return dp[index];
    }
    
    // SIMPLE RECURSION - gives TLE in bigger data-set
    private int rec(int index, int[] arr, int n) {
        if (index > n) return 0;
        if (index == n) return arr[index];
        int pick = arr[index] + rec(index + 2, arr, n);
        int notPick = rec(index + 1, arr, n);
        return pick > notPick ? pick : notPick;
    }
}
