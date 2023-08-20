 class Solution {
    public int coinChange(int[] coins, int amount) {
       // return recBase(coins, amount);
      // return memoBase(coins, amount);
      return dp(coins, amount);
    }


   // DYNAMIC TABULATION
    private int dp(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // tabulate base condition
        for (int amt = 1; amt <= amount; amt ++) {
            int c = coins[0];
            if ((amt % c) != 0) dp[0][amt] = (int)1e9;
            else dp[0][amt] = amt / c;
        }

        for (int index = 1; index < n; index ++) {
            for (int amt = 1; amt <= amount; amt ++) {
                int take = Integer.MAX_VALUE;
                int notTake = 0 + dp[index - 1][amt];

                int c = coins[index];
                if (c <= amt) take = 1 + dp[index][amt - c];

                dp[index][amt] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        if (ans >= (int)1e9) return -1;
        return ans;        
    }

   // MEMOIZATION
    private int memoBase(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        int ans = memo(n - 1, coins, amount, dp);
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    // returns the minimum number of coins
    private int memo(int index, int[] coins, int amount, Integer[][] dp) {
        // base condition
        if (index == 0) {
            int c = coins[0];
            if ((amount % c) != 0) return (int)1e9;
            return amount / c;
        }

        if (dp[index][amount] != null) return dp[index][amount];

        int take = Integer.MAX_VALUE;
        int notTake = 0 + memo(index - 1, coins, amount, dp);

        int c = coins[index];
        if (c <= amount) take = 1 + memo(index, coins, amount - c, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }









// RECURSION
    private int recBase(int[] coins, int amount) {
        int n = coins.length;
        int ans = rec(n - 1, coins, amount);
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    // returns the minimum number of coins
    private int rec(int index, int[] coins, int amount) {
        // base condition
        if (index == 0) {
            int c = coins[0];
            if ((amount % c) != 0) return (int)1e9;
            return amount / c;
        }

        int take = Integer.MAX_VALUE;
        int notTake = 0 + rec(index - 1, coins, amount);

        int c = coins[index];
        if (c <= amount) take = 1 + rec(index, coins, amount - c);

        return Math.min(take, notTake);
    }
}
