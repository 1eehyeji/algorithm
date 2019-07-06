package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 병든 나이트
 * N, M의 최대 값이 2,000,000,000이기 때문에 배열 사용하지 않음
 */
public class B1783 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if(n == 1) System.out.println(1);
		else if(n == 2) {
			if(m < 7) {
				System.out.println((m+1)/2);
			}
			else System.out.println(4);	//n이 2일 경우에는 모든 조건을 만족할 수 없기 때문에 최대 4칸
		}
		else {
			if(m < 5) // 이동횟수가 4미만의 경우
				System.out.println(m);
			else if(m < 7)	//m이 7보다 작을 경우 모든 조건을 만족할 수 없기 때문에 최대 4칸
				System.out.println(4);
			else
				System.out.println(m-2);
				// 모든 조건을 만족하면 5칸을 이동한 상태이고,
				// 그 다음부터는 마음대로 이동할 수 있기 때문에 오른쪽으로 한칸 씩만 이동하는 것이
				// 최대로 움직일 수 있는 방법이므로 조건을 만족하기 위한 칸(총 7칸)을 제외한 모든 칸으로 이동할 수 있음
				// 즉, 5 + (m - 7)
		}
	}

}
