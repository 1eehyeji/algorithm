package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2448 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] a = new String[n];

		a[0] = "  *  ";
		a[1] = " * * ";
		a[2] = "*****";

		int m = (int)(Math.log(n/3)/Math.log(2));	// 3*2^k 에서 k의 값
		int height = 3;

		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < height; ++j) {
				a[height + j] = a[j] + " " + a[j];
				for(int r = 0; r < height/3; ++r) {		// 위에 있는 줄에 공백을 추가함
					a[j] = "   " + a[j] + "   ";
				}
			}
			height += height;
		}

		for(String s : a)
			System.out.println(s);
	}

}
