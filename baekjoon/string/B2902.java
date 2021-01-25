package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// KMP는 왜 KMP일까?
public class B2902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] names = br.readLine().split("-");

		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			sb.append(name.charAt(0));
		}

		System.out.println(sb.toString());
	}
}
