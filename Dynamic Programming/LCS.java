
public class Solution {

	public static int lcs(String s, String t) {
        // return rec(s.length() - 1, t.length() - 1, s, t);
        
//         Integer[][] dp = new Integer[s.length()][t.length()];
//         return memo(s.length() - 1, t.length() - 1, s, t, dp);
        
        return dp(s, t);
    }
    
    // TABULATION : SIMPLE : USING THE CONCEPT OF INDEX SHIFTING
    private static int dp(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for (int index1 = 0; index1 <= s.length(); index1 ++) {
            for (int index2 = 0; index2 <= t.length(); index2 ++) {
                if (index1 == 0 || index2 == 0) {
                    dp[index1][index2] = 0;
                    continue;
                }
                char c1 = s.charAt(index1 - 1);
                char c2 = t.charAt(index2 - 1);

                if (c1 == c2) dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }
        return dp[s.length()][t.length()];
    }
    
    // TABULATION : INDEX IS SAME, SO NEEDS MODIFICATION IN BASE CASE
    private static int dp2(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        boolean match = false;
      
      // as soon as we have a common letter, set the answer as 1
        for (int i = 0; i < s.length(); i ++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(0);
            if (c1 == c2) match = true;
            if (match) dp[i][0] = 1;
            else dp[i][0] = 0;
        }
        match = false;
        for (int i = 1; i < t.length(); i ++) {
            char c1 = s.charAt(0);
            char c2 = t.charAt(i);
            if (c1 == c2) match = true;
            if (match) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        
        for (int index1 = 1; index1 < s.length(); index1 ++) {
            for (int index2 = 1; index2 < t.length(); index2 ++) {
                char c1 = s.charAt(index1);
                char c2 = t.charAt(index2);

                if (c1 == c2) dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }
    
    // MEMOIZATION SOLUTION
    private static int memo(int index1, int index2, String s, String t, Integer[][] dp) {
        // base case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        
        if (dp[index1][index2] != null) return dp[index1][index2];
        char c1 = s.charAt(index1);
        char c2 = t.charAt(index2);
        
        if (c1 == c2) return 1 + memo(index1 - 1, index2 - 1, s, t, dp);
        
        return dp[index1][index2] = Math.max(memo(index1 - 1, index2, s, t, dp), memo(index1, index2 - 1, s, t, dp));
    }
    
    // RECURSIVE SOLUTION
    private static int rec(int index1, int index2, String s, String t) {
        // base case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        
        char c1 = s.charAt(index1);
        char c2 = t.charAt(index2);
        
        if (c1 == c2) return 1 + rec(index1 - 1, index2 - 1, s, t);
        
        return Math.max(rec(index1 - 1, index2, s, t), rec(index1, index2 - 1, s, t));
    }

}
