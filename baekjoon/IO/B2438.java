package baekjoon.IO;

import java.util.Scanner;

public class B2438 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j < i; ++j) {
				builder.append("*");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}
