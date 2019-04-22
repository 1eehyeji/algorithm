package baekjoon.Stack;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {

	static void solution(String s) {
		int value = 1; 
		int result = 0;
		char pre;
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			
			switch(c) {
			case '(':
				stack.push(c);
				value *= 2;
				break;            
			case '[':
				stack.push(c);
				value *= 3;
				break;
			case ')':
				if(stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				
				pre = stack.peek();
				if(pre != '(') {
					System.out.println("0");
					return;
				}
				
				stack.pop();
				if(s.charAt(i-1) == '(') result += value;
				value /= 2;
				break;
			case ']':
				if(stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				
				pre = stack.peek();
				if(pre != '[') {
					System.out.println("0");
					return;
				}
				
				stack.pop();
				if(s.charAt(i-1) == '[') result += value;
				value /= 3;
				break;
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.println("0");
			return;
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s = br.readLine();
		solution(s);
	}

}
