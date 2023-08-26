class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // recursive solution
        // return rec(n - 1, amount, coins);

        // memoization solution
        // Integer[][] dp = new Integer[n][amount + 1];
        // return memo(n - 1, amount, coins, dp);

        // dynamic programming
        return dp(amount, coins, n);
    }

    // dynamic programming
    private int dp(int amount, int[] coins, int n) {
        int[][] dp = new int[n][amount + 1];

        for (int index = 0; index < n; index ++) dp[index][0] = 1;

        // base condition tabulation
        for (int amt = 0; amt <= amount; amt ++) {
            if (coins[0] > amt) dp[0][amt] = 0;
            if ((amt % coins[0]) != 0) dp[0][amt] = 0;
            else dp[0][amt] = 1;
        }
        for (int index = 1; index < n; index ++) {
            for (int amt = 1; amt <= amount; amt ++) {
                int take = 0;
                int notTake = dp[index - 1][amt];
                int c = coins[index];
                if (c <= amt) take = dp[index][amt - c];
                dp[index][amt] = take + notTake;     
            }
        }
        return dp[n - 1][amount];
    }

    

    // memoization solution
    private int memo(int index, int amount, int[] coins, Integer[][] dp) {
        // base condition
        if (index == 0) {
            if (amount == 0) return dp[0][amount] = 1;
            if (coins[0] > amount) return dp[0][amount] = 0;
            if ((amount % coins[0]) != 0) return dp[0][amount] = 0;
            else return dp[0][amount] = 1;
        }
        if (dp[index][amount] != null) return dp[index][amount];
        int take = 0;
        int notTake = memo(index - 1, amount, coins, dp);
        int c = coins[index];
        if (c <= amount) take = memo(index, amount - c, coins, dp);
        return dp[index][amount] = take + notTake;        
    }


    // recursive solution
    // returns number of ways
    private int rec(int index, int amount, int[] coins) {
        // base condition
        if (index == 0) {
            if (amount == 0) return 1;
            if (coins[0] > amount) return 0;
            if ((amount % coins[0]) != 0) return 0;
            else return 1;
        }
        int take = 0;
        int notTake = rec(index - 1, amount, coins);
        int c = coins[index];
        if (c <= amount) take = rec(index, amount - c, coins);
        return take + notTake;        
    }
}
