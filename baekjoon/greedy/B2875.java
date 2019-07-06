package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 대회 or 인턴
public class B2875 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 여학생 수
		int m = Integer.parseInt(st.nextToken()); // 남학생 수
		int k = Integer.parseInt(st.nextToken()); // 인턴쉽 인원

		int count = 0;

		while(n+m >= k+3) {	// n+m이 k명 + 3 보다 크다면 팀을 짤 수 있음
			if(n >= 2 && m >= 1) {	// 여학생이 2명보다 많고 남학생이 1명보다 많은 경우
				n -= 2; // 팀을 이룬 인원만큼 뺌
				m -= 1;
				++count;	// 팀의 개수를 늘림
			}
			else break;	// 팀을 이룰 수 없는 경우 반복을 빠져나옴
		}

		System.out.println(count);
	}

}
