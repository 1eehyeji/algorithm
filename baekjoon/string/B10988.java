package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 펠린드롬인지 확인하기
public class B10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int middle = (str.length() / 2) - 1;

		boolean isPalindrome = true;
		for (int i = 0; i <= middle; ++i) {
			if (str.charAt(i) != str.charAt((str.length() - 1) - i)) {
				isPalindrome = false;
				break;
			}
		}

		System.out.println(isPalindrome ? 1 : 0);
	}
}
