package baekjoon.IO;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2741 {
	
	static void solution(int n) {
		if(n < 1) return;
		solution(n - 1);
		System.out.println(n);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		solution(n);
	}
}
