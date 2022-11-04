import java.util.* ;
import java.io.*; 
public class Solution {
	public static int lcs(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
        int ans = 0;
        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                
                else dp[i][j] = 0;
                
                if (dp[i][j] > ans) ans = dp[i][j];
            }
        }
        return ans;
	}
}
