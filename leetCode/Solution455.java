package leetCode;

import java.util.Arrays;

// Assign Cookies
public class Solution455 {

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ++count;
                ++i;
            }
            ++j;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};

        System.out.println(findContentChildren(g, s));
    }
}
