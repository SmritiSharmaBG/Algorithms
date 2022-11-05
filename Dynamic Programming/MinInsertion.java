import java.util.* ;
import java.io.*; 
public class Solution {
  // Minimum insertions to make a string palindrome
    public static int minInsertion(String str) {
    	StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                char c1 = str.charAt(i - 1);
                char c2 = rev.charAt(j - 1);
                
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
      // lps = LONGEST COMMON SUBSEQUENCE WHICH IS PALINDROME
        int lps = dp[n][n];
      // MIN INSERTION IS LEFT PART OF THE STRING WHICH COULD NOT MAKE PLINDROME 
        return (n - lps);
    }
}
