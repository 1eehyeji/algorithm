package baekjoon.iO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2588번 곱셈 (https://www.acmicpc.net/problem/2588)
public class B2588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		br.close();

		int NM = N * M;

		while (M > 0) {
			int m = M % 10;
			M /= 10;

			bw.write(String.valueOf(N * m));
			bw.newLine();
		}

		bw.write(String.valueOf(NM));

		bw.flush();
		bw.close();
	}
}
