package baekjoon.iO;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11023 {
	
	static int sum(int[] n, int length) {
		if(length < 0) return 0;		
		return n[length] + sum(n, length - 1);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int[] n = new int[s.length];
		
		for(int i = 0; i < s.length; ++i) {
			n[i] = Integer.parseInt(s[i]);
		}
		
		System.out.println(sum(n, n.length - 1));
	}

}
