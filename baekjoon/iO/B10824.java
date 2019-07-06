package baekjoon.iO;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10824 {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		/* 14자리 수는 int 범위를 넘어감
		int a = Integer.parseInt(s[0] + s[1]);
		int b = Integer.parseInt(s[2] + s[3]);
		
		System.out.println(a + b);
		*/
		
		// 수정
		long answer = Long.valueOf(s[0] + s[1]) + Long.valueOf(s[2] + s[3]);
		System.out.println(answer);
	}

}
