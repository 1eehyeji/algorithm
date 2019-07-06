package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 회의실 배정
public class B1931 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Meeting meeting;
		List<Meeting> list = new ArrayList<Meeting>();
		while(n --> 0) {	//	List에 주어진 회의정보를 추가함
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meeting = new Meeting(s, e);
			list.add(meeting);
		}

		Collections.sort(list);

		int current = 0;
		int count = 0;
		for(int i = 0; i < list.size(); ++i) {
			// 현재 회의가 끝나는 시간이 다음 회의의 시작 시간과 같거나 큰 경우
			if(list.get(i).start >= current) {
				++count;		// 회의실 빌려준 횟수를 추가
				current = list.get(i).end;	// 다음 회의가 끝나는 시간을 저장
			}
		}

		System.out.println(count);
	}

}
class Meeting implements Comparable<Meeting>{ // 회의 시작시간과 끝나는 시간을 저장
	int start;
	int end;
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Meeting m) {
		if(this.end < m.end) return -1; // 끝나는 시간 오름차순 정렬
		else if(this.end == m.end) {	// 끝나는 시간이 같은 경우
			if(this.start > m.start) return 1;	// 시작 시간이 작은 경우가 우선
			else return -1;
		}
		return 1;
	}
}
