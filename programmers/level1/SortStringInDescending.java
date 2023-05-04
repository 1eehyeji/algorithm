package programmers.level1;

import java.util.*;

public class SortStringInDescending {
	static public String solution(String s) {
		String answer = "";

		String[] alphabets = s.split("");
		Arrays.sort(alphabets, Collections.reverseOrder());

		answer = String.join("", alphabets);

		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
}
