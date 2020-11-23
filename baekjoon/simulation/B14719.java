package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*빗물
*
* 2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.
* 비는 충분히 많이 온다. 고이는 빗물의 총량은 얼마일까?
*
* 첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)
* 두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.
* 따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.
*
* 2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.
* 빗물이 전혀 고이지 않을 경우 0을 출력하여라.
* */
public class B14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] heights = new int[W];

		st = new StringTokenizer(br.readLine());
		int tokenCount = st.countTokens();
		for (int i = 0; i < tokenCount; ++i) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		for (int i = 1; i < heights.length - 1; ++i) {
			int nowH = heights[i];
			int leftMaxH = getMaxHeight(heights, 0, i + 1);
			int rightMaxH = getMaxHeight(heights, i, heights.length);

			answer += Math.min(leftMaxH, rightMaxH) - nowH;
		}

		System.out.println(answer);

		br.close();
	}

	private static int getMaxHeight(int[] heights, int startIndex, int endIndex) {
		int max = 0;
		for (int i = startIndex; i < endIndex; ++i) {
			max = Math.max(max, heights[i]);
		}

		return max;
	}
}
