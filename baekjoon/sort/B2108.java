package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.util.Arrays.stream;

/* 백준 2108번 통계학
*
* 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
* 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
* 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
* 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
* N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
*
* 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다.
* 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
*
* 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
* 둘째 줄에는 중앙값을 출력한다.
* 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
* 넷째 줄에는 범위를 출력한다.
* */
public class B2108 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];
		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		numbers = stream(numbers).sorted().toArray(); // 정렬

		int 산술평균 = 산술평균구하기(numbers);
		int 중앙값 = 중앙값구하기(numbers);
		int 최빈값 = 최빈값구하기(numbers);
		int 범위 = 범위구하기(numbers);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(산술평균));
		bw.newLine();
		bw.write(String.valueOf(중앙값));
		bw.newLine();
		bw.write(String.valueOf(최빈값));
		bw.newLine();
		bw.write(String.valueOf(범위));

		bw.flush();
		bw.close();
	}

	public static int 산술평균구하기(int[] a) {
		int sum = 0;

		for (int i : a) {
			sum += i;
		}

		double avg = (double) sum / a.length;

		int 산술평균 = (int) Math.round(avg);

		return 산술평균;
	}

	public static int 중앙값구하기(int[] a) {
		int index = a.length / 2;

		return a[index];
	}

	public static int 최빈값구하기(int[] a) {
		int[] count = new int[8001];    // -4000 ~ 4000 사이의 값을 표현하기 위해
		int maxNumber = 4000;

		for (int i = 0; i < a.length; ++i) {
			++count[a[i] + maxNumber];    // -4000 ~ 4000 사이의 값에 4000을 더해서 index로 사용
		}

		int max = Integer.MIN_VALUE;

		for (int i : count) {
			if (max < i) {
				max = i;
			}
		}

		int maxValueCount = 0;
		int index = 0;

		for (int i = 0; i < count.length; ++i) {
			if (count[i] == max) {
				++maxValueCount;
				index = i;
			}
			if (maxValueCount == 2) {
				index = i;
				break;
			}
		}

		return index - maxNumber;
	}

	public static int 범위구하기(int[] a) {
		int max = a[a.length - 1];
		int min = a[0];

		return max - min;
	}
}
