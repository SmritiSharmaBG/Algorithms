package Recusrion;

import java.util.ArrayList;

public class SortAnArray {
    public static void main(String[] args) {
        int[] arr = {9, 6, 0, 1, 7};
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : arr) a.add(i);
        a = sort(a);
        for (int i : a) System.out.print(i + " ");
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> arr) { // Returns a sorted array
        int n = arr.size();
        if (n == 1) return arr; // BASE CONDITION
        int last = arr.get(n - 1); // get the last element
        ArrayList<Integer> a = sort(new ArrayList<>(arr.subList(0, n - 1))); // RECURSIVE CALL
        for (int i = 0; i < n; i++) { // add the last element at appropriate place
            if (a.get(i) > last) {
                a.add(i, last);
                break; // once added, get out of the loop because it will give wrong answer
            }
        }
        return a; // return the sorted array that was created
    }
}
