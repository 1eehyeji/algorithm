package baekjoon.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

/* 백준 1966번 프린트 큐
*
* 1. 현재 Queue 의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
* 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고
*    Queue 의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
 */
public class B1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 문서의 수
			int M = Integer.parseInt(st.nextToken()); // 순서가 궁금한 문서의 현재 위치

			Queue<Document> orders = new LinkedList<>();
			List<Integer> priorities = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; ++i) {
				int priority = Integer.parseInt(st.nextToken());

				orders.add(new Document(i, priority));
				priorities.add(priority);
			}

			priorities = priorities.stream()
					.sorted(Collections.reverseOrder())
					.collect(Collectors.toList());

			int count = 0;

			while (orders.size() != 0) {
				Document document = orders.poll();

				if (priorities.get(0) == document.priority) {	// 현재 문서의 우선순위가 가장 큰 경우 -> 인쇄

					priorities.remove(0);
					++count;

					if (M == document.index) {	// 궁금한 문서가 인쇄된 경우 -> 인쇄된 순서를 출력
						bw.write(count + "\n");
					}

				} else {	// 우선순위가 가장 크지 않은 경우 -> 큐의 맨 뒤로 보냄
					orders.add(document);
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

class Document {

	int index;	// 문서의 처음 index

	int priority;	// 우선 순위

	public Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}
