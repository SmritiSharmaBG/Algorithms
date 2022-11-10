class Solution {
  // returns 1 if Palindrome, returns 0 if not palindrome
  
    int isPalindrome(String s) {
        
      // USING STRING BUILDER 
        // space : O(1)
        // time : O(n)
        /*
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return s.equalsIgnoreCase(rev) ? 1 : 0;
        */
        
        // ITERATIVE
        // space : O(1)
        // time : O(n / 2)
        int right = s.length() - 1;
        int left = 0;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 != c2) return 0;
            left ++;
            right --;
        }
        return 1;
    }
}
