package programmers;

public class 숫자의표현 {
	static int solution(int n) {
		int answer = 0;
		int[] nums = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			for (int j = i; j <= n; ++j) {
				nums[i] += j;
				if (nums[i] > n) {
					break;
				}
				if (nums[i] == n) {
					++answer;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
	}
}
