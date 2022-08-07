package SearchingSorting;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(aggressiveCows(arr, n, c));
        }
    }

    private static int aggressiveCows(int arr[], int n, int cows) {
        int low = 1; // min distance between any 2 cows
        int high = arr[n - 1] - arr[0]; // max distance possible in the given stall arrangement
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(arr, n, cows, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    private static boolean canPlaceCows(int[] arr, int n, int cows, int distance) {
        int occStall = arr[0];
        int placedCows = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - occStall >= distance) {
                placedCows++;
                occStall = arr[i];
            }
            if (placedCows == cows) return true;
        }
        return false;
    }
}
