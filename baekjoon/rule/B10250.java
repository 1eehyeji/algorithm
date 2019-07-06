package baekjoon.rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 백준 10250번 ACM 호텔
*
* 각 층에 W 개의 방이 있는 H 층 건물이라고 가정하자 (1 ≤ H, W ≤ 99).
* 모든 인접한 두 방 사이의 거리는 같은 거리(거리 1)라고 가정하고 호텔의 정면 쪽에만 방이 있다고 가정한다.
* 방 번호는 YXX 나 YYXX 형태인데 여기서 Y 나 YY 는 층 수를 나타내고
* XX 는 엘리베이터에서부터 세었을 때의 번호를 나타낸다.
* 걷는 거리가 같을 때에는 아래층의 방을 더 선호한다.
* 여러분이 작성할 프로그램은 초기에 모든 방이 비어있다고 가정하에 이 정책에 따라 N 번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램이다.
* */
public class B10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		while (T --> 0) {
			st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if(N % H == 0) {
				int X = N / H;
				//System.out.printf("%d%02d\n", H, X);
				System.out.println(H + "" + (X >= 10 ? X : "0" + X));
			}
			else {
				int X = (N / H) + 1;
				//System.out.printf("%d%02d\n", N % H, X);
				System.out.println((N % H) + "" + (X >= 10 ? X : "0" + X));
			}
		}

		br.close();
	}
}
