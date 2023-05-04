package programmers.kakao2019;

import java.util.*;

public class 실패율 {
	static int[] solution(int N, int[] stages) {
		int[] counts = new int[N + 2];
		List<Stage> stageList = new ArrayList<>();

		for (int i : stages) {
			counts[i] += 1;
		}

		for (int i = 1; i <= N; ++i) {
			double notClearCount = counts[i];
			double arrivedCount = 0;

			for (int j = i; j <= N + 1; ++j) {
				arrivedCount += counts[j];
			}

			double failureRate = arrivedCount == 0 ? 0 : (notClearCount / arrivedCount);
			stageList.add(new Stage(i, failureRate));
		}

		Collections.sort(stageList, (o1, o2) -> {
			if (o1.failureRate == o2.failureRate) {
				return o1.stage - o2.stage;
			}

			return o2.failureRate.compareTo(o1.failureRate);
		});

		int[] answer = new int[N];

		for (int i = 0; i < N; ++i) {
			answer[i] = stageList.get(i).stage;
		}

		return answer;
	}

	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4, 4, 4, 4, 4};

		System.out.println(Arrays.toString(solution(N, stages)));
	}
}

class Stage {
	int stage;
	Double failureRate;

	public Stage(int stage, Double failureRate) {
		this.stage = stage;
		this.failureRate = failureRate;
	}
}