package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 1697 숨바꼭질
/*    ---문제---
 *    수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
 *    동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
 *    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 *    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
// bfs를 사용하여 문제 해결
public class B1697 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] visited = new int[1000001];	// 방문한 적이 있는지, 몇초에 도착했는지 저장
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[n] = 1;
		q.offer(n);
		
		while(!q.isEmpty()) { 	//bfs
			int m = q.poll();
			if(m == k) {		// 동생 위치에 도착한 경우
				System.out.println(visited[m]-1);
				return;
			}
			else {
				if(m-1 >= 0 && visited[m-1] == 0) {	// 한 칸 뒤
					visited[m-1] = visited[m] + 1;
					q.offer(m-1);
				}
				if(m+1 <= 100000 && visited[m+1] == 0) {	// 한 칸 앞
					visited[m+1] = visited[m] + 1;
					q.offer(m+1);
				}
				if(2*m <= 100000 && visited[2*m] == 0) {	// 순간이동
					visited[2*m] = visited[m] + 1;
					q.offer(2*m);
				}
			}
		}
	}

}
