package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 1157번 단어 공부
* 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
* 단, 대문자와 소문자를 구분하지 않는다.
* 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
* */
public class B1157_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine().toUpperCase();

		int max = 0;
		String answer = "";

		while (s.length() != 0) {
			String str = s.replaceAll(s.substring(0,1), "");
			int num = s.length() - str.length();

			if(num > max) {
				max = num;
				answer = s.substring(0, 1);
			} else if(num == max) {
				answer = "?";
			}

			s = str;
		}

		System.out.println(answer);
	}
}
