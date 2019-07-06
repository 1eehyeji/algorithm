package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 잃어버린 괄호
public class B1541 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s += "+"; // +, -가 나왔을 경우 값을 더하거나 빼기 위해서

		int result = 0;
		int i = 0; // -가 처음 나온 인덱스를 저장함
		String number = "";
		// 첫 번째 -가 나올때까지 반복
		for(i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if('0' <= c && c <= '9') {
				number += String.valueOf(c); // 숫자를 문자로 더해서 저장함
			}
			else if(c == '+') {
				result += Integer.parseInt(number); // +가 나온경우 숫자를 더함
				number = "";
			}
			else if(c == '-') {	// -가 나오면 앞의 숫자는 더하고 반복문을 빠져나옴
				result += Integer.parseInt(number);
				number = "";
				break;
			}
		}

		for(int j = i+1; j < s.length(); ++j) {	// -이 처음 나온 index+1부터 반복문을 시작함
			char c = s.charAt(j);
			if('0' <= c && c <= '9') {
				number += String.valueOf(c);
			} else {
				result -= Integer.parseInt(number); // 뺄셈 뒤로 괄호가 있다고 생각하고 후에 나올 모든 값을 뺄셈함ㅁ
				number = "";
			}
		}

		System.out.println(result);
	}

}
