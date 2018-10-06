package baekjoon.Collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10828 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		Stack stack = new Stack(count);
		
		for(int i = 0; i < count; ++i) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			case "push":
				stack.push(Integer.parseInt(s[1]));
				break;
			case "pop":
				stack.pop();
				break;
			case "size":
				stack.size();
				break;
			case "empty":
				stack.empty();
				break;
			case "top":
				stack.top();
				break;
			}
		}
	}

}

class Stack{
	private int[] stack;
	private int size = 0;
	
	public Stack(int count) {
		stack = new int[count];
	}
	public void push(int n) {
		stack[size] = n;
		++size;
	}
	public void pop() {
		if(size == 0) System.out.println("-1");
		else{
			System.out.println(stack[size-1]);
			--size;
		}
	}
	public void size() {
		System.out.println(size);
	}
	public void empty() {
		if(size == 0) System.out.println("1");
		else System.out.println("0");
	}
	public void top() {
		if(size == 0) System.out.println("-1");
		else System.out.println(stack[size-1]);
	}
}
