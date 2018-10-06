package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 수 묶기
public class B1744 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수열의 크기

		List<Integer> plus = new ArrayList<>(); // 양수 저장
		List<Integer> minus = new ArrayList<>(); // 음수 저장

		int zero = 0; // 0의 개수
		int one = 0; // 1의 개수

		while(n --> 0) {	// 수열을 저장함
			int m = Integer.parseInt(br.readLine());
			if(m > 1) plus.add(m);
			else if(m < 0) minus.add(m);
			else if(m == 1) one += 1;
			else if(m == 0) zero += 1;
		}

		int result = 0; // 계산 결과를 저장

		Collections.sort(plus); // 오름차순으로 정렬
		// 양수의 개수가 홀수일 경우 가장 작은 양수를 제외하고 묶음
		if(plus.size()%2 != 0) {
			result += plus.get(0);
			for(int i = 1; i < plus.size(); i+=2) {
				result += (plus.get(i)*plus.get(i+1));
			}
		}else if(plus.size()%2 == 0) {
			for(int i = 0; i < plus.size(); i+=2) {
				result += (plus.get(i)*plus.get(i+1));
			}
		}

		Collections.sort(minus);
		Collections.reverse(minus); // 내림차순으로 정렬
		// 음수의 개수가 홀수인 경우 절대값이 가장 작은 음수를 제외하고 묶음
		if(minus.size()%2 != 0) {
			if(zero > 0) { // 0이 하나라도 있는 경우 절대값이 가장 작은 음수와 곱하여 값에 더함
				result += minus.get(0)*0;
				zero -= 1;
			} else {		// 0이 없는 경우 절대값이 가장 작은 음수를 더함
				result += minus.get(0);
			}
			for(int i = 1; i < minus.size(); i+=2) {
				result += (minus.get(i)*minus.get(i+1));
			}
		}else if(minus.size()%2 == 0) {
			for(int i = 0; i < minus.size(); i+=2) {
				result += (minus.get(i)*minus.get(i+1));
			}
		}

		result += one;	// 1은 묶지 않고 값에 더함

		System.out.println(result);
	}

}
