class Solution
{ 
  //  return the sum of minimum and maximum element in the array.
    public static int findSum(int A[],int N) 
    {
        if (N < 2) return (2 * A[0]);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i + 1 < N) {
            int a = A[i];
            int b = A[i + 1];
            if (a < b) {
                if (b > max) max = b;
                if (a < min) min = a;
            } else {
                if (a > max) max = a;
                if (b < min) min = b;
            }
            i = i + 2;
        }
        if (i == N - 1) {
            if (A[i] < min) min = A[i];
            else if (A[i] > max) max = A[i];
        }
        return min + max;
    }
}
