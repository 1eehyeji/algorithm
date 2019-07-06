package baekjoon.string;

import java.util.Scanner;

/* 백준 2908번 상수
*  ...상근이는 수의 크기를 비교하는 문제를 내주었다. 상근이는 세 자리 수 두 개를 칠판에 써주었다.
*  그 다음에 크기가 큰 수를 말해보라고 했다.
*  상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
*  예를 들어, 734과 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
*  따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
*
*  첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다.
*  두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
 * */
public class B2908_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] n = new int[2];
		for(int i = 0; i < 2; ++i) {
			int num = sc.nextInt();
			String s = "";
			while(num > 0) {
				s += String.valueOf(num % 10);
				num /= 10;
			}
			n[i] = Integer.parseInt(s);
		}

		System.out.println(Math.max(n[0], n[1]));

		sc.close();
	}
}
