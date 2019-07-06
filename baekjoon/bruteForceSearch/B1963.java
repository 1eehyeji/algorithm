package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 1963 소수 경로
/* --문제--
 * 소수를 유난히도 좋아하는 창영이는 게임 아이디 비밀번호를 4자리 ‘소수’로 정해놓았다
 * “흠... 생각 좀 해볼게. 이 게임은 좀 이상해서 비밀번호를 한 번에 한 자리 밖에 못 바꾼단 말이야.
 * 예를 들어 내가 첫 자리만 바꾸면 8033이 되니까 소수가 아니잖아.
 * 여러 단계를 거쳐야 만들 수 있을 것 같은데... 예를 들면... 1033 1733 3733 3739 3779 8779 8179처럼 말이야.”
 * 입력은 항상 네 자리 소수만(1000 이상) 주어진다고 가정하자.
 * 주어진 두 소수 A에서 B로 바꾸는 과정에서도 항상 네 자리 소수임을 유지해야 하고, 
 * ‘네 자리 수’라 하였기 때문에 0039 와 같은 1000 미만의 비밀번호는 허용되지 않는다.
 */
// bfs를 사용하여 문제 해결
public class B1963 {

	static int nextNumber(int n, int i, int j) { // 숫자 n의 i위치 값을 j로 바꿈
		String s = String.valueOf(n);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, (char)(j+'0'));
		return Integer.parseInt(sb.toString());
	}

	static boolean[] prime() {	//에라토스테네스의 체를 사용하여 소수 확인을 위한 배열 생성
		boolean[] p = new boolean[10000];
		Arrays.fill(p, true);
		p[1] = false;
		int N = (int) Math.sqrt(9999);
		for (int i = 2; i <= N; i++) {
			if (p[i]) {
				for (int j = 2; i*j <= 9999; j++) {
					p[i*j] = false;
				}
			}
		}
		return p;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[] prime = prime();

		for(int r = 0; r < t; ++r) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] visited = new int[100001];
			Queue<Integer> q = new LinkedList<Integer>();

			visited[n] = 1;
			q.offer(n);
			while(!q.isEmpty()) {
				int x = q.poll();
				if(x == m) {
					System.out.println(visited[x] - 1);
					continue;
				}
				else {
					for(int i = 0; i < 4; ++i) {
						for(int j = 0; j < 10; ++j) {
							if(i == 0 && j == 0) continue;
							int y = nextNumber(x, i, j); // 현재 숫자, 바꿀 위치, 바꿀 숫자
							if(prime[y] && visited[y] == 0) {
								q.offer(y);
								visited[y] = visited[x] + 1;
							}
						}
					}
				}
			}
			if(visited[m] == 0) { // 불가능한 경우
				System.out.println("Impossible");
			}
		}
	}

}
