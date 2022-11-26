class Solution
{
  // TIME COMPLEXITY : O(N)
  // SPACE COMPLEXITY : O(1)
    public static void sort012(int a[], int n)
    {
        int z = 0;
        int o = 0;
        int t = 0;
        // O(n)
        for (int i : a) {
            if (i == 0) z ++;
            if (i == 1) o ++;
            if (i == 2) t ++;
        }
        int p = 0;
        while (z > 0) {
            z --;
            a[p] = 0;
            p ++;
        }
        while (o > 0) {
            o --;
            a[p] = 1;
            p ++;
        }
        while (t > 0) {
            t --;
            a[p] = 2;
            p ++;
        }
    }
}
