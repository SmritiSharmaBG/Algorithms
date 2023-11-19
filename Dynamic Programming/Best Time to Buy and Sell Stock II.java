class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // recursive solution
        // return rec(0, true, prices);

        // memoization
        Integer[][] memo = new Integer[len][2]; // true - false
        // return memo(0, true, prices, memo);

        return dp(prices);
    }

    // tabulation
    private int dp(int[] prices) {
        int len = prices.length;

        int dp[][] = new int[len + 1][2];

        // base condition
        dp[len][0] = dp[len][1] = 0;

        for (int index = len - 1; index >= 0; index --) {
            for (int canBuy = 0; canBuy <= 1; canBuy ++) { // 0 -> true & 1 -> false
                int profit = 0;
                if (canBuy == 0) {
                    int buy = dp[index + 1][1] - prices[index];
                    int notBuy = dp[index + 1][0];
                    profit = Math.max(buy, notBuy);
                } else { // i can sell
                    int sell = dp[index + 1][0]+ prices[index];
                    int notSell = dp[index + 1][1];
                    profit = Math.max(sell, notSell);
                }
                dp[index][canBuy] = profit;
            }
        }

        return dp[0][0];
    }

    // memoization
    private int memo(int index, boolean canBuy, int[] prices, Integer[][] memo) {
        // base case
        if (index == prices.length) return 0;

        if (canBuy && memo[index][0] != null) return memo[index][0];

        if (!canBuy && memo[index][1] != null) return memo[index][1];
        

        // i can buy
        if (canBuy) {
            int buy = memo(index + 1, false, prices, memo) - prices[index];
            int notBuy = memo(index + 1, true, prices, memo) - 0;
            return memo[index][0] = Math.max(buy, notBuy);
        } else {
            int sell = memo(index + 1, true, prices, memo) + prices[index];
            int notSell = memo(index + 1, false, prices, memo) + 0;
            return memo[index][1] = Math.max(sell, notSell);
        }
    }

    // return maximum profit possible
    private int rec(int index, boolean canBuy, int[] prices) {
        // base condition
        if (index == prices.length) {
            return 0;
        }

        // i can buy
        if (canBuy) {
            int profit = 0;
            int buy = rec(index + 1, false, prices) - prices[index];
            int notBuy = rec(index + 1, true, prices) - 0;
            return Math.max(buy, notBuy);
        } else { // i can sell
            int sell = rec(index + 1, true, prices) + prices[index];
            int notSell = rec(index + 1, false, prices) + 0;
            return Math.max(sell, notSell);
        }
    }
}
