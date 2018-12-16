package baekjoon.BruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 6603 로또
/*  ---문제---
 *	독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
 *	로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
 *	예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
 *	집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 */
// 백트래킹을 사용하여 모든 경우 탐색
public class B6603 {

	static void dfs(int[] a, int index, int count, String s) {
		if(count == 6) {
			System.out.println(s);
		}
		else {
			if(index >= a.length) return;
			dfs(a, index+1, count+1, s+a[index]+" "); // 해당 노드를 문자열에 추가하고 다른 노드를 탐색한다.
			dfs(a, index+1, count, s); // 해당 노드를 문자열에 추가하지 않고 다른 노드를 탐색한다. (백트래킹)
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) return;
			int[] a = new int[k];

			for(int i = 0; i < k; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a); // 입력을 오름차순으로 받기 때문에 이 문제에서는 안해도 괜찮음

			dfs(a, 0, 0, "");
			System.out.println();
		}
	}

}
