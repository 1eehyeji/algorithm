package baekjoon.iO;

import java.util.Scanner;

public class B2439 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n ; ++j) {
				if(j <= n-i) {
					builder.append(" ");
				}
				else
					builder.append("*");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}
