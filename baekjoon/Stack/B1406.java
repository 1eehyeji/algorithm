package baekjoon.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();

        for(int i = 0; i < str.length(); ++i){
            left.push(str.charAt(i));
        }

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; ++i){
            String cmd = br.readLine();

            if(cmd.charAt(0) == 'L') {
                if (!left.empty()) right.push(left.pop());
            }
            else if(cmd.charAt(0) == 'D') {
                if (!right.empty()) left.push(right.pop());
            }
            else if(cmd.charAt(0) == 'B') {
                if (!left.empty()) left.pop();
            }
            else if(cmd.charAt(0) == 'P') left.push(cmd.charAt(2));
        }

        br.close();

        while (!left.empty()){
            right.push(left.pop());
        }
        while(!right.empty()){
            System.out.print(right.pop());
        }
    }
}
