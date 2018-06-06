package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 한이음 ICT 멘토링 코딩테스트 1
public class Solution1 {
	static int solution(int n, int m) {
		int answer = 0;

		for(int i = n; i <= m; ++i) {
			if(i == reverse(i)) ++answer;
		}
		return answer;
	}
	public static int reverse(int n) {
		String s = n + "";
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < s.length(); ++i) {
			list.add(s.charAt(i));
		}
		Collections.reverse(list);
		String s1 = "";
		for(char c : list) {
			s1 += c;
		}
		return Integer.parseInt(s1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		int m = 100;
		
		System.out.println(solution(n, m));
	}

}
