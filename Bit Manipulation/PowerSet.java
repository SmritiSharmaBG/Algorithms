class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> ans = new ArrayList<>(); 
        int n = s.length();
        int total = 1 << n; // 2 ^ n
        char[] arr = s.toCharArray();
        for (int i = 1; i < total; i ++) {
            String str = "";
            for (int j = 0; j < n; j ++) {
                if ((i & (1 << j)) != 0) {
                    str = str + arr[j];
                }
            }
            ans.add(str);
        }
        Collections.sort(ans);
        return ans;
    }
}
