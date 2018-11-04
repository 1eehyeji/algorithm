package baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 중량제한
public class B1939 {

	// mid 값으로 물건을 옮길 수 있는지 검사
	static boolean solution(Map<Integer, List<Node>> graph, int start, int goal, int mid) {
		boolean[] b = new boolean[graph.size()+1];
		Queue<Integer> queue = new LinkedList<>();
		b[start] = true;
		queue.add(start);

		while(!queue.isEmpty()) {
			int k = queue.remove();
			for(Node node : graph.get(k)) {
				if(!b[node.next]) {
					if(node.weight >= mid) {
						if(node.next == goal)
							return true;
						b[node.next] = true;
						queue.add(node.next);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, List<Node>> graph = new HashMap<>();
		for(int i = 0; i < n; ++i) {
			graph.put(i+1, new ArrayList<>());
		}

		int max = 0;
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());	// 중량
			max = Math.max(max, c);
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int min = 1;
		int result = 0;
		while(min <= max) {
			int mid = (min + max) / 2;
			if(solution(graph, start, goal, mid)) {
				result = Math.max(result, mid);
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

}

class Node{
	int next;
	int weight;

	public Node(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}
}