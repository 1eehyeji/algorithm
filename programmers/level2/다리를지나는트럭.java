package programmers.level2;

public class 다리를지나는트럭 {
	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int[] location = new int[truck_weights.length];
		int nowWeight = 0;
		int now = 0;
		int start = 0;

		boolean flag = true;

		while (flag) {
			++time;

			if (now < truck_weights.length && weight >= nowWeight + truck_weights[now]) {
				nowWeight += truck_weights[now];
				++now;
			}

			for (int i = start; i < now; ++i) {				// 1초 동안 트럭이 한 칸씩 이동함
				++location[i];

				if (location[i] == bridge_length) {			// 다음 1초 후에 다음 트럭이 올 수 있게 미리 무게를 뻬둠
					nowWeight -= truck_weights[i];
				}

				if (location[i] > bridge_length) {			// 트럭이 다리를 지나간 경우
					if (i == (truck_weights.length - 1)) {	// 마지막 트럭 까지 지나가면 반복문을 빠져나감
						flag = false;
					}
					++start;
				}
			}
		}

		return time;
	}

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};

		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
