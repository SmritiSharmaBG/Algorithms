class Solution
{
    public int longestPalinSubseq(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                int c1 = s.charAt(i - 1);
                int c2 = t.charAt(j - 1);
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
