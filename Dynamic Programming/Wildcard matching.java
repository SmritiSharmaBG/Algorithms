class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        
        // recursive solution
        //return rec(len1 - 1, len2 - 1, s, p);

        // tabulation
        return dp(len1, len2, s, p);
    }

    private boolean dp(int len1, int len2, String s, String p) {
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;

        int index = 1;
        while (index <= len2 && p.charAt(index - 1) == '*') dp[0][index ++] = true;

        for (int i = 1; i <= len1; i ++) { 
            for (int j = 1; j <= len2; j ++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);

                if (c1 == c2 || c2 == '?') dp[i][j] = dp[i - 1][j - 1];

                else if (c2 == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                else if (c1 != c2) dp[i][j] = false;
            }
        }
        return dp[len1][len2];
    }

    private boolean rec(int i, int j, String s, String p) {
        // base condition
        // both are exhausted : matching complete successfully
        if (i < 0 && j < 0) return true;

        // only pattern is exhausted, but string has elements : matching failed
        if (j < 0 && i >= 0) return false;

        // string is exhausted, but pattern has elements : ONLY * allowed now
        if (i < 0 && j >= 0 && p.charAt(j) == '*') return rec(i, j - 1, s, p);

        else if (i < 0 && j >= 0 && p.charAt(j) != '*') return false;

        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if (c1 == c2 || c2 == '?') return rec(i - 1, j - 1, s, p);

        if (c2 == '*') return rec(i - 1, j, s, p) || rec(i, j - 1, s, p);

        if (c1 != c2) return false;

        return true;
    }
}
