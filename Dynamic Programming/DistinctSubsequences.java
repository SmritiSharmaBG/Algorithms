class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        // recursive solution
        // return rec(len1 - 1, s, len2 - 1, t);

        // memoization
        // Integer[][] memo = new Integer[len1][len2];
        // return memo(len1 - 1, s, len2 - 1, t, memo);

        // dynamic programming
        return dp(len1, s, len2, t);
    }

    // dynamic programming
    private int dp(int len1, String s1, int len2, String s2) {
        int[][] dp = new int[len1][len2];

        if (s1.charAt(0) == s2.charAt(0)) dp[0][0] = 1; 

        for (int i = 1; i < len1; i ++) {
            if (s1.charAt(i) == s2.charAt(0)) dp[i][0] = dp[i - 1][0] + 1;
            else dp[i][0] = dp[i - 1][0];
        }

        for (int index1 = 1; index1 < len1; index1 ++) {
            for (int index2 = 1; index2 < len2; index2 ++) {
                char c1 = s1.charAt(index1);
                char c2 = s2.charAt(index2);

                if (c1 == c2) 
                dp[index1][index2] = dp[index1 - 1][index2 - 1] + dp[index1 - 1][index2];

                else dp[index1][index2] = dp[index1 - 1][index2];
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    // memoization solution
    private int memo(int index1, String s1, int index2, String s2, Integer[][] memo) {
        if (index2 < 0) return 1;
        if (index1 < 0 ) return 0;

        if(memo[index1][index2] != null) return memo[index1][index2];

        char c1 = s1.charAt(index1);
        char c2 = s2.charAt(index2);

        if (c1 == c2) 
        return memo[index1][index2] = memo(index1 - 1, s1, index2 - 1, s2, memo) + memo(index1 - 1, s1, index2, s2, memo);

        else return memo[index1][index2] = memo(index1 - 1, s1, index2, s2, memo);
    }


    // recursive solution
    private int rec(int index1, String s1, int index2, String s2) {
        if (index2 < 0) return 1;
        if (index1 < 0 ) return 0;

        char c1 = s1.charAt(index1);
        char c2 = s2.charAt(index2);

        if (c1 == c2) 
        return rec(index1 - 1, s1, index2 - 1, s2) + rec(index1 - 1, s1, index2, s2);

        else return rec(index1 - 1, s1, index2, s2);
    }
}
