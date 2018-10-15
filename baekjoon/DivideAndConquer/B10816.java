package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 숫자카드2 : binary search하면 시간초과 나옴
public class B10816 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> a = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			Integer key = Integer.parseInt(st.nextToken());
			Integer value = a.get(key);
			if(value != null) {			// 이미 존재하는 키는 value + 1 해서 다시 저장
				a.put(key, value+1);
			}
			else {
				a.put(key, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder builder = new StringBuilder();

		for(Integer i : b) {
			builder.append(a.get(i) == null ? "0 " : a.get(i) + " ");	// i 값이 map에 존재하지 않으면 0을 출력
		}

		System.out.println(builder.toString());
	}

}
