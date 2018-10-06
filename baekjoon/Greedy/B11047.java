package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//동전0
public class B11047 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 만들고 싶은 합

		int[] a = new int[n];
		for(int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(br.readLine()); // 동전 값을 저장함

		int count = 0; // 필요한 동전 개수
		for(int i = n-1; i >= 0; --i) { // 가장 큰 값의 동전부터 사용
			if(k >= a[i]) {
				k -= a[i]; // 사용한 동전의 가치만큼 뺌
				++i;	// 사용한 동전부터 다시 반복문을 시작하기 위해
				++count;
			}
			else if(k == 0) break; // 합을 만들면 반복문을 빠져나옴
		}

		System.out.println(count);
	}

}
