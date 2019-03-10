package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ����������
public class B1977 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		int n2 = (int) Math.sqrt(n);
		int m2 = (int) Math.sqrt(m);
		
		for(int i = n2; i <= m2; ++i) {
			int a = i * i;
			if(n <= a && a <= m) {
				sum += a;
				min = Math.min(min, a);
			}
		}
		
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
