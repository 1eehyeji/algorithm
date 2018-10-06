package baekjoon.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int result = 0;

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);

            if(c == '(') stack.push(c);
            else if(c == ')'){
                if(s.charAt(i - 1) == '('){
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }

        br.close();
        System.out.println(result);
    }
}
