package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭발
public class B9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bombStr = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int k = 0; k < str.length(); ++k) {
            stack.push(str.charAt(k));

            if (bombStr.charAt(bombStr.length() - 1) == stack.peek()
                    && stack.size() >= bombStr.length()) {
                Stack<Character> s = new Stack<>();
                boolean isEquals = true;
                for (int i = 0; i < bombStr.length(); ++i) {
                    s.push(stack.pop());
                    if (s.peek() != bombStr.charAt(bombStr.length() - (i + 1))) {
                        isEquals = false;
                        break;
                    }
                }
                if (!isEquals) {
                    while (!s.isEmpty()) {
                        stack.push(s.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            stack.forEach(sb::append);
            System.out.println(sb.toString());
        }
    }
}
