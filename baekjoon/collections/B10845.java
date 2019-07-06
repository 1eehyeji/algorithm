package baekjoon.collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10845 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		Queue queue = new Queue(count);
		
		for(int i = 0; i < count; ++i) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			case "push":
				queue.push(Integer.parseInt(s[1]));
				break;
			case "pop":
				queue.pop();
				break;
			case "size":
				queue.size();
				break;
			case "empty":
				queue.empty();
				break;
			case "front":
				queue.front();
				break;
			case "back":
				queue.back();
				break;
			}
		}
	}

}

class Queue{
	private int[] queue;
	private int size = 0;
	private int front = 0;
	private int back = 0;
	
	public Queue(int count) {
		queue = new int[count];
	}
	public void push(int n) {
		queue[back] = n;
		++back;
		++size;
	}
	public void pop() {
		if(size == 0) System.out.println("-1");
		else{
			System.out.println(queue[front]);
			++front;
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
	public void front() {
		if(size == 0) System.out.println("-1");
		else System.out.println(queue[front]);
	}
	public void back() {
		if(size == 0) System.out.println("-1");
		else System.out.println(queue[back - 1]);
	}
}
