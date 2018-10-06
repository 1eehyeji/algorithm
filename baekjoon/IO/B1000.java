package baekjoon.IO;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1000 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);

		System.out.println(a + b);
	}

}
