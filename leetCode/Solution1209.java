package leetCode;

import java.util.Stack;

public class Solution1209 {

    public String removeDuplicates(String s, int k) {
        StringBuilder answer = new StringBuilder();

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty() || (stack.peek().c != s.charAt(i))) {
                stack.push(new Pair(s.charAt(i), 1));
                continue;
            }

            if (!stack.isEmpty() && (stack.peek().c == s.charAt(i))) {
                Pair p = stack.pop();
                ++p.count;

                stack.push(p);
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        for (Pair p : stack) {
            answer.append(p.getStr());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";

        Solution1209 solution = new Solution1209();
        System.out.println(solution.removeDuplicates(s, 2));
    }

    class Pair {

        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        String getStr() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; ++i) {
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
