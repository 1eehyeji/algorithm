package programmers.level2;

public class 다음큰숫자 {
	public int solution(int n) {
		int answer = n + 1;
		String nToBinary = Integer.toBinaryString(n);
		int countOneOfN = countOne(nToBinary);

		while (true) {
			String nextToBinary = Integer.toBinaryString(answer);
			int countOneOfNext = countOne(nextToBinary);

			if (countOneOfN == countOneOfNext)
				break;

			++answer;
		}

		return answer;
	}

	// Integer.bitCount(n) 함수로 대체 가능
	static int countOne(String binaryString) {
		int count = 0;
		for (char c : binaryString.toCharArray()) {
			count += (c == '1') ? 1 : 0;
		}
		return count;
	}
}
