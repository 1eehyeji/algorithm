package algorithm_pt;

import java.util.Arrays;

// 	두 문자열을 비교해서 하나의 문자 삽입, 삭제, 교체 해서 같게 만들 수 있는지
//	ex1 : pale, ple = true;
//	ex2 : pales, pale = true;
//	ex3 : pale, bale = true;
//	ex4 : pale, bake = false;
public class StringCompare {
	public static void main(String[] args) {
		String s1 = "pales";
		String s2 = "ale";

		int length1 = s1.length();
		int length2 = s2.length();

		// 비교해서 문자열 길이가 같으면 교체해서 같게 만들 수 있는지 확인
		if (length1 == length2) {
			char[] chars1 = s1.toCharArray();
			char[] chars2 = s2.toCharArray();

			boolean flag = false;
			for (int i = 0; i < chars1.length; ++i) {
				if (chars1[i] != chars2[i]) {
					if (flag) {
						System.out.println(false);
						return;
					}
					flag = true;
				}
			}
		// 문자열 길이가 다르면 추가/삭제해서 같게 만들 수 있는지 확인
		} else if (Math.abs(length1 - length2) == 1) {
			String longerStr = s1.length() > s2.length() ? s1 : s2;
			String shorterStr = s1.length() < s2.length() ? s1 : s2;

			char[] chars1 = longerStr.toCharArray();
			char[] chars2 = shorterStr.toCharArray();

			boolean flag = false;
			int index = 0;
			for (char c : chars2) {
				if (chars1[index] != c) {
					if (flag) {
						System.out.println(false);
						return;
					}
					flag = true;
				}
				++index;
			}
		} else {
			System.out.println(false);
			return;
		}

		System.out.println(true);
	}

}
