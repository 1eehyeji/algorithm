package baekjoon.IO;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10822 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(",");
		int sum = 0;
		
		for(int i = 0; i < s.length; ++i) {
			sum += Integer.parseInt(s[i]);
		}
		
		System.out.println(sum);
		
		/*
			, 를 기준으로 줄을 나누어 사용
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			st.nextToken();
			st.hasMoreTokens();
		 */
	}

}
