package baekjoon.rule;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2292 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 1;

		int num = 7;
		while(n > num) {
			++count;
			num += 6 * count;
		}
		++count;

		if(n == 1) count = 1;
		System.out.println(count);
	}

}
