class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // recursive method
        // return rec(0, true, prices, 0);

        // memoization
        Integer[][][] memo = new Integer[len][2][3];
        // return memo(0, true, prices, 0, memo);

        // tabulation
        return dp(prices, len);
    }

    // tabulation
    private int dp(int[] prices, int len) {
        int[][][] dp = new int[len + 1][2][3];

        for (int canBuy = 0; canBuy <= 1; canBuy ++) { // 0 -> true; 1 -> false
            for (int trans = 0; trans <= 2; trans ++ ) {
                dp[len][canBuy][trans] = 0;
            }
        }


        for (int index = len - 1; index >= 0; index --) {
            for (int canBuy = 0; canBuy <= 1; canBuy ++) { // 0 -> true; 1 -> false
                for (int trans = 0; trans <= 1; trans ++ ) {
                        if (canBuy == 0) {
                        int buy = dp[index + 1][1][trans] - prices[index];
                        int notBuy = dp[index + 1][0][trans];
                        dp[index][canBuy][trans] = Math.max(buy, notBuy);
                    } else {
                        int sell = dp[index + 1][0][trans + 1] + prices[index];
                        int notSell = dp[index + 1][1][trans];
                        dp[index][canBuy][trans] =  Math.max(sell, notSell);
                    }
                } // trans
            } // canBuy
        } // index

        return dp[0][0][0];
    }

    // memoization memo[][][] : 
    // canBuy -> true - false 
    // trans -> 0 - 1
    private int memo(int index, boolean canBuy, int[] prices, int trans, Integer[][][] memo) {
        // base condition
        if (index >= prices.length || trans >= 2) {
            return 0;
        }

        if (canBuy && trans == 0 && memo[index][0][0] != null) return memo[index][0][0];
        if (canBuy && trans == 1 && memo[index][0][1] != null) return memo[index][0][1];
        if (!canBuy && trans == 0 && memo[index][1][0] != null) return memo[index][1][0];
        if (!canBuy && trans == 1 && memo[index][1][1] != null) return memo[index][1][1];

        if (canBuy) {
            int buy = memo(index + 1, false, prices, trans, memo) - prices[index];
            int notBuy = memo(index + 1, true, prices, trans, memo);
            return memo[index][0][trans] = Math.max(buy, notBuy);
        } else {
            int sell = memo(index + 1, true, prices, trans + 1, memo) + prices[index];
            int notSell = memo(index + 1, false, prices, trans, memo);
            return memo[index][1][trans] = Math.max(sell, notSell);
        }
    }

    // return the maximum profit
    private int rec(int index, boolean canBuy, int[] prices, int trans) {
        // base condition
        if (index >= prices.length || trans >= 2) {
            return 0;
        }

        if (canBuy) {
            int buy = rec(index + 1, false, prices, trans) - prices[index];
            int notBuy = rec(index + 1, true, prices, trans);
            return Math.max(buy, notBuy);
        } else {
            int sell = rec(index + 1, true, prices, trans + 1) + prices[index];
            int notSell = rec(index + 1, false, prices, trans);
            return Math.max(sell, notSell);
        }
    }
}
