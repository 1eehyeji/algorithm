package baekjoon.iO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2753번 윤년 (https://www.acmicpc.net/problem/2753)
public class B2753 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int Y = Integer.parseInt(br.readLine());

		System.out.println(isLeapYear(Y));
	}

	public static int isLeapYear(int y) {
		if (y % 400 == 0) {
			return 1;
		} else {
			return (y % 4 == 0) && (y % 100 != 0) ? 1 : 0;
		}
	}
}
