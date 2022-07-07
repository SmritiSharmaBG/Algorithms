package Recusrion;

public class PrintAllSubsequence {
    private static String str;
    private static int len;

    public static void main(String[] args) {
        str = "Smriti";
        len = str.length();
        rec(0, "");
    }

    private static void rec(int i, String s) {
        if (i == len) {
            System.out.println(s);
            return;
        }
        rec(i + 1, s);
        s = s + str.charAt(i);
        rec(i + 1, s);
    }
}
