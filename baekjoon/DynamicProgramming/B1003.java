package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1003 {
	static int[] d;

	static int fibonacci(int n) {
		if(n <= 0) {
			return 0;
		}
		if(d[n] != 0) {
			return d[n];
		}
		if(n == 1) {
			d[1] = 1;
			return 1;
		}
		return d[n] = fibonacci(n-2) + fibonacci(n-1);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			d = new int[n+1];
			fibonacci(n);
			if(n == 0) System.out.println("1 0");
			else System.out.println(d[n-1] + " " + d[n]);
		}
	}

}
