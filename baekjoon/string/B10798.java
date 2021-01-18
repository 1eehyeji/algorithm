package baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10798 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] words = new char[5][15];
		for (int i = 0; i < 5; ++i) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < chars.length; ++j) {
				words[i][j] = chars[j];
			}
		}

		br.close();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 15; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (words[j][i] != '\u0000' && words[j][i] != ' ')
					bw.write(words[j][i]);
			}
		}

		bw.flush();
		bw.close();
	}
}
