class Solution
{
    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
        String c = s1 + s1;
        if (s1.length() != s2.length()) return false;
        return (c.indexOf(s2) != -1);
    }
    
  /* TIME COMPLEXITY : O(N1 * N2)
  SPACE COMPEXITY : O(N1) + O(N2)
  */
    private static boolean approach1(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2) return false;
        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < l1; i ++) q1.add(s1.charAt(i));
        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < l1; i ++) q2.add(s2.charAt(i));
        int count = 0;
        while (count < l1) {
            if (q1.equals(q2)) return true;
            q2.add(q2.remove());
            count ++;
        }
        return false;
    }
}
