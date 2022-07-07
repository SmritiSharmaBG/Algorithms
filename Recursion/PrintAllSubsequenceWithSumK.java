package Recusrion;

import java.util.ArrayList;

public class PrintAllSubsequenceWithSumK {
    private static int[] arr = {6, 5, 7, 5, 2, 4, 1, 3};
    private static int len = 8;
    private static int target = 10;

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        rec(0, a, 0);
    }

    private static void rec(int i, ArrayList<Integer> a, int sum) {
        if (i == len) {
            if (sum == target) {
                for (int it : a)
                    System.out.print(it + " ");
                System.out.println();
            }
            return;
        }
        rec(i + 1, a, sum);
        int temp = arr[i];
        sum += temp;
        a.add(temp);
        rec(i + 1, a, sum);
        a.remove(a.size() - 1);
    }
}
