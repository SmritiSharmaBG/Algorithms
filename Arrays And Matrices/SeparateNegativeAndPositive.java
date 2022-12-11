import java.util.* ;
import java.io.*; 
public class Solution {
  
  // TIME COMPLEXITY : O(n) 
  // SPACE COMPLEXITY : O(1)
  
    public static ArrayList<Integer> separateNegativeAndPositive(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        // if a number is at apt position, we move on
        // if it is at sus position, we remain there or swap
        while (low <= high) {
            int l = nums.get(low);
            int h = nums.get(high);
            if (l < 0 && h < 0) {
                low ++;
            } else if (l < 0 && h >= 0) {
                low ++;
                high --;
            } else if (l >= 0 && h < 0) {
                nums.set(low, h);
                nums.set(high, l);
                low ++;
                high --;
            } else if (l >= 0 && h >= 0) {
                high --;
            }
        }
        
  
