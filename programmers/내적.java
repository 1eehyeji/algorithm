package programmers;

public class 내적 {
    public static int Solution(int[] a, int[] b) {
        int 내적 = 0;
        for (int i = 0; i < a.length; ++i) {
            내적 += a[i] * b[i];
        }

        return 내적;
    }
}
