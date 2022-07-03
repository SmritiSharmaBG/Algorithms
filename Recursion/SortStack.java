package Recusrion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        int[] arr = {9, 6, 100, 11, 7, -87};
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) stack.push(i);
        stack = sort(stack);
        for (int i : stack) System.out.print(i + " "); // this will print the order in stack as it is.
    }

    /**
     * Recursive function to sort the stack passed in argument
     *
     * @param stack
     * @return sorted array
     */
    private static Stack<Integer> sort(Stack<Integer> stack) {
        int n = stack.size();
        if (n == 1) return stack; // BASE CONDITION
        int last = stack.pop();
        Stack<Integer> s = sort(stack); // RECURSIVE CALL
        s = sortedInsert(s, last);
        return s;
    }

    /**
     * Recursive function to insert i at appropriate place in sorted stack
     *
     * @param s sorted stack
     * @param i element that has to be inserted
     * @return sorted stack with element added at correct place
     */
    private static Stack<Integer> sortedInsert(Stack<Integer> s, int i) {
        if (s.isEmpty() || s.peek() < i) { // BASE CONDITION
            s.push(i);
            return s;
        }
        int last = s.pop();
        s = sortedInsert(s, i); // RECURSIVE CALL
        s.push(last);
        return s;
    }
}
