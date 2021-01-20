package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하얀 칸
public class B1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = 8;
		int countF = 0;

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				// 짝수 번째 줄에서 짝수 칸 || 홀수 번째 줄에서 홀수 칸 => 흰칸
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
					// 흰칸에 말이 존재하면 count 증가
					if (str.charAt(j) == 'F') ++countF;
				}
			}
		}

		System.out.println(countF);
	}
}
