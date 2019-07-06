package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2331 {
	static int[] c = new int[1000000];

	static int solution(int a, int p, int count) {
		if(c[a] != 0) return c[a] - 1;
		c[a] = count;
		int index = next(a, p);
		return solution(index, p, count + 1);
	}
	static int next(int a, int p) {
		int index = 0;
		while(a > 0) {
			index += (int)Math.pow((a%10), p);
			a /= 10;
		}
		return index;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		br.close();

		System.out.println(solution(a, p, 1));
	}

}
