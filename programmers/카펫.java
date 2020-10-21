package programmers;

public class 카펫 {

	static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int gridCount = brown + yellow;

		for (int h = 3; h < (gridCount / 2); ++h) {
			if ((gridCount % h) == 0) {
				int w = gridCount / h;

				if (((h - 2) * (w - 2)) == yellow) {
					answer[0] = w;
					answer[1] = h;
					break;
				}
			}
		}

		return answer;
	}
}
