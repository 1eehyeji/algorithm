package baekjoon.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {
	static void solution(String s) {

		Stack<Character> stack = new Stack<>();

		for(int j = 0; j < s.length(); ++j) {
			char c = s.charAt(j);
			if(c == '(') stack.push(c);
			else if(c == ')') {
				if(!stack.empty()) stack.pop();
				else {
					System.out.println("NO");
					return;
				}
			}
		}

		if(!stack.empty())System.out.println("NO");
		else System.out.println("YES");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for(int i = 0; i < count; ++i) {
			String s = br.readLine();
			solution(s);
		}

		br.close();
	}
}
