class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // find xor of all numbers
        
        int x = 0;
        for(int i : nums) x = x ^ i;
        
        // categorize all numbers by finding the probable candidate
        
        int a = 0; // is having 1's
        int b = 0; // is having 0's
        
        // find the index of last set bit
        int index = 0;
        while (x != 0) {
            if ((x & 1) == 1) break;
            index ++;
            x = x >> 1;
        }
        
        for(int i : nums) {
            if((i & (1 << index)) != 0) a = a ^ i;
            else b = b ^ i;
        }
        
        int[] ans = new int[2];
        ans[0] = a < b ? a : b;
        ans[1] = a > b ? a : b;
        
        return ans;
    }
}
