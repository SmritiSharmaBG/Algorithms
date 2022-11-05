import java.util.* ;
import java.io.*; 
public class Solution {
  // Minimum Number of Deletions and Insertions to convert str -> ptr
    public static int canYouMake(String str, String ptr) {
        int l1 = str.length();
        int l2 = ptr.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i ++) {
            for (int j = 1; j <= l2; j ++) {
                char c1 = str.charAt(i - 1);
                char c2 = ptr.charAt(j - 1);
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int lcs = dp[l1][l2];
        int delete = l1 - lcs;
        int insert = l2 - lcs;
        return delete + insert;
    }
}
