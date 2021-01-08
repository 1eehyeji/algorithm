package programmers;

import java.util.*;

public class 소수만들기 {

	public static int solution(int[] nums) {
		boolean[] primeNumbers = new boolean[1001];
		Arrays.fill(primeNumbers, true);
		primeNumbers[0] = primeNumbers[1] = false;

		for (int i = 2; i * i < primeNumbers.length; ++i) {
			for (int j = i * i; j < primeNumbers.length; j += i) {
				primeNumbers[j] = false;
			}
		}

		int answer = 0;

		for (int i = 0; i < nums.length; ++i) {
			int sum = nums[i];
			for (int j = i + 1; j < nums.length; ++j) {
				sum += nums[j];
				for (int k = j + 1; k < nums.length; ++k) {
					sum += nums[k];
					if (primeNumbers[sum]) {
						System.out.println(sum);
						++answer;
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
	}

}
