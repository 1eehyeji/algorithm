package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 롤러코스터
public class B2873 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] a = new int[r][c];
		for(int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; ++j) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder builder = new StringBuilder();
		if(r%2 != 0 && c%2 != 0) { // 홀*홀
			for(int i = 0; i < r; ++i) {
				for(int j = 0; j < c-1; ++j) {
					if(i%2 == 0)
						builder.append("R");
					else
						builder.append("L");
				}
				if(i != (r-1))
					builder.append("D");
			}
		}
		else if(r%2 != 0 && c%2 == 0) { // 홀*짝
			for(int i = 0; i < r; ++i) {
				for(int j = 0; j < c-1; ++j) {
					if(i%2 == 0)
						builder.append("R");
					else
						builder.append("L");
				}
				if(i != (r-1))
					builder.append("D");
			}
		}
		else if(r%2 == 0 && c%2 != 0) { // 짝*홀
			for(int i = 0; i < c; ++i) {
				for(int j = 0; j < r-1; ++j) {
					if(i%2 == 0)
						builder.append("D");
					else
						builder.append("U");
				}
				if(i != (c-1))
					builder.append("R");
			}
		}
		else if(r%2 == 0 && c%2 == 0) { // 짝*짝 모든 칸을 지날 수 없음
			// 행렬을 흰색과 검은색으로 칠한다고 할 때
			int min = Integer.MAX_VALUE;	// 검은색 칸 중 기쁨이 가장 작은 칸을 구함
			int x = 0;
			int y = 1;
			for(int i = 0; i < r; i+=2) {	// 짝수번째 행일 때
				for(int j = 1; j < c; j+=2) {
					if(min > a[i][j]) {
						min = a[i][j];
						x = i;
						y = j;
					}
				}
			}
			for(int i = 1; i < r; i+=2) {	// 홀수번째 행일 때
				for(int j = 0; j < c; j+=2) {
					if(min > a[i][j]) {
						min = a[i][j];
						x = i;
						y = j;
					}
				}
			}

			int R = x%2 != 0 ? x - 1 : x;	// 모두 지나갈 수 있는 횟수
			for(int i = 0; i < R; ++i) {
				for(int j = 0; j < c-1; ++j)
					if(i%2 == 0)
						builder.append("R");
					else
						builder.append("L");
				builder.append("D");
			}

			int C = y;	// (x, y)와 근접할 때까지 이동함
			for(int i = 0; i < C; ++i) {
				if(i%2 == 0)
					builder.append("DR");
				else
					builder.append("UR");
			}

			for(int i = C; i < c-1; ++i) {	// 해당 행의 남은 칸을 모두 지남
				if(i%2 == 0)
					builder.append("RD");
				else
					builder.append("RU");
			}

			if(x%2 == 0)	// 남은 칸을 모두 지나감
				R = r - (x+2);
			else
				R = r - (x+1);
			for(int i = 0; i < R; ++i) {
				builder.append("D");
				for(int j = 0; j < c-1; ++j) {
					if(i%2 == 0)
						builder.append("L");
					else
						builder.append("R");
				}
			}
		}
		System.out.println(builder.toString());
	}

}
