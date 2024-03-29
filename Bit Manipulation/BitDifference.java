class Solution{  
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        int x = a ^ b;
        int count = 0;
      
        while (x != 0) {
            x = x & (x - 1);
            count ++;
        }
      
        return count;
    }
}
