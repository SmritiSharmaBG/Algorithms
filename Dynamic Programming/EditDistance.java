class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        // recursive solution
        // return rec(len1 - 1, len2 - 1, word1, word2);

        // memoization
        // Integer[][] memo = new Integer[len1][len2];
        // return memo(len1 - 1, len2 - 1, word1, word2, memo);

        // dynamic programming
        return dp(len1, len2, word1, word2);
    }

    // dynamic programming
    private int dp(int len1, int len2, String word1, String word2) {
        int[][] dp = new int[len1 + 1][len2 + 1];

        // word2 is exhausted --> we need to delete rest letters of word1
        for (int i = 1; i <= len1; i ++) {
            dp[i][0] = i;
        }

        // word1 is exhausted --> we need to insert rest letters of word2
        for (int i = 1; i <= len2; i ++) {
            dp[0][i] = i;
        }
        
        for (int index1 = 1; index1 <= len1; index1 ++) {
            for (int index2 = 1; index2 <= len2; index2 ++) {
                char c1 = word1.charAt(index1 - 1);
                char c2 = word2.charAt(index2 - 1);

                if (c1 == c2) dp[index1][index2] = dp[index1 - 1][index2 - 1];

                else {
                    int insert = 1 + dp[index1][index2 - 1];
                    int delete = 1 + dp[index1 - 1][index2];
                    int replace = 1 + dp[index1 - 1][index2 - 1];
                    dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[len1][len2];
    }

    // memoization
    private int memo(int index1, int index2, String word1, String word2, Integer[][] memo) {
        // word1 is exhausted --> we need to insert rest letters of word2
        if (index1 < 0) return index2 + 1;
        // word2 is exhausted --> we need to delete rest letters of word1
        if (index2 < 0) return index1 + 1;

        if (memo[index1][index2] != null) return memo[index1][index2];
        char c1 = word1.charAt(index1);
        char c2 = word2.charAt(index2);

        if (c1 == c2) return memo[index1][index2] = memo(index1 - 1, index2 - 1, word1, word2, memo);
        else {
            int insert = 1 + memo(index1, index2 - 1, word1, word2, memo);
            int delete = 1 + memo(index1 - 1, index2, word1, word2, memo);
            int replace = 1 + memo(index1 - 1, index2 - 1, word1, word2, memo);
            return memo[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }
    }

    // recursive solution
    private int rec(int index1, int index2, String word1, String word2) {
        // word1 is exhausted --> we need to insert rest letters of word2
        if (index1 < 0) return index2 + 1;
        // word2 is exhausted --> we need to delete rest letters of word1
        if (index2 < 0) return index1 + 1;
        char c1 = word1.charAt(index1);
        char c2 = word2.charAt(index2);

        if (c1 == c2) return rec(index1 - 1, index2 - 1, word1, word2);
        else {
            int insert = 1 + rec(index1, index2 - 1, word1, word2);
            int delete = 1 + rec(index1 - 1, index2, word1, word2);
            int replace = 1 + rec(index1 - 1, index2 - 1, word1, word2);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
}
