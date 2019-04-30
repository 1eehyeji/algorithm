package baekjoon.Rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 1193번 분수찾기
*
* 이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은
* 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
* X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
* 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
* */
public class B1193 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());

		int denominator = 1;
		int numerator = 1;

		// 1/n 에서 n/1 혹은 n/1에서 1/n으로 번호가 커지는 경로를 대각선이라고 표현하면
		int maxNumber = 1;	// 현재 대각선 경로에서 가장 큰 번호 (해당 번호의 분수는 1/n 또는 n/1 형태)
		int count = 1;		// 지나온 대각선 경로의 수

		while(maxNumber < X) {
			++count;
			maxNumber += count;	// 1 + 2 + 3 + ...
		}

		int minusValue = maxNumber - X;	// 구하려는 번호와 가장 큰 번호의 차를 구함

		if(count % 2 == 0) {	// 짝수 번 대각선 이동한 경우 (가장 큰 번호에 해당하는 분수는 count/1)
			denominator += minusValue;	// 작은 번호로 이동할수록 분모 값 증가
			numerator = count - minusValue;	// 작은 번호로 이동할수록 분자 값 감소
		}
		else {	// 홀수 번 대각선 이동한 경우 (가장 큰 번호에 해당하는 분수는 1/count)
			denominator = count - minusValue;	// 짝수 경우와 반대
			numerator += minusValue;
		}

		bw.write(numerator + "/" + denominator);

		br.close();
		bw.close();
	}
}
