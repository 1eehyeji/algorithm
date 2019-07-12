package baekjoon.iO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2884번 알람 시계 (https://www.acmicpc.net/problem/2884)
public class B2884 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		br.close();

		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		if (minute < 45) {
			--hour;
		}

		hour = hour < 0 ? (hour + 24) : hour;
		minute = ((60 + minute) - 45) % 60;

		System.out.println(hour + " " + minute);
	}
}
