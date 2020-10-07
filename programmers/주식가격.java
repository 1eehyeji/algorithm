package programmers;

import java.util.Arrays;

public class 주식가격 {

	static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		int count = 0;

		for (int i = 0; i < prices.length; ++i) {
			for (int j = i + 1; j < prices.length; ++j) {
				++count;
				if (prices[i] > prices[j]) {
					answer[i] = count;
					break;
				}
			}
			answer[i] = count;
			count = 0;
		}

		return answer;
	}
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		System.out.println(Arrays.toString(solution(prices)));
	}
}
