package baekjoon.rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 백준 6064번 카잉달력
*
* 그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다.
* 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다.
* <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다.
* 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다.
* <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다.
* 네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.
*
* 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
* 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다. (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N)
* 만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.
 * */
public class B6064 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		while(T --> 0) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int lastYear = lcm(M, N);	// 마지막 해 => 최소공배수

			bw.write(String.valueOf(solution(M, N, y, x, lastYear)));
			bw.newLine();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	// 재귀함수를 사용하여 해를 구함
	public static int solution(int M, int N, int y, int k, int lastYear) {
		if(lastYear < k) {	// 유효하지 않은 표현인 경우
			return -1;
		}

		int n = k % N == 0 ? N : k % N;	// k가 N의 배수인 경우 나머지가 0인 경우 발생

		if(n == y) {	// 표현되는 해가 있는 경우
			return k;
		}

		return solution(M, N, y, k + M, lastYear);
	}

	// 최대공약수
	public static int gcd(int a, int b) {
		int min = Math.min(a, b);
		int gcd = Integer.MIN_VALUE;

		for(int i = 1; i <= min; ++i) {
			if((a % i == 0) && (b % i ==0)) {
				gcd = i;
			}
		}

		return gcd;
	}

	// 최소공배수
	public static int lcm(int a, int b) {
		int gcd = gcd(a, b);

		a /= gcd;
		b /= gcd;

		return gcd * a * b;
	}
}