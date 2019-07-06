package baekjoon.rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 2292번 벌집
*
* 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때
* 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
* 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
* 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
* */
public class B2292_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int maxRoomNumber = 1;	// 지나가는 방의 최소 개수가 변하지 않는 최대 번호

		for(int i = 1 ; ; ++i) {
			if(maxRoomNumber >= N) {
				bw.write(String.valueOf(i));
				break;
			}
			maxRoomNumber += i * 6;
		}

		br.close();
		bw.close();
	}

}
