package programmers;

public class 타겟넘버 {
	static int count  = 0;

	static int solution(int[] numbers, int target) {
		recursive(numbers, target, numbers[0], 1);
		recursive(numbers, target, -numbers[0], 1);
		return count;
	}

	static void recursive(int[] numbers, int target, int value, int i) {
		if (i == numbers.length) {
			if (target == value)
				++count;
			return;
		}

		recursive(numbers, target, value + numbers[i], i + 1);
		recursive(numbers, target, value - numbers[i], i + 1);
	}

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;

		System.out.println(solution(numbers, target));
	}
}
