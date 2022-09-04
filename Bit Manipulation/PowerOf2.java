class Solution{
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        if(n == 0l) return false;
        if((n & (n-1)) == 0) return true;
        return false;
    }
}
