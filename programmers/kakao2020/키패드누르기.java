package programmers.kakao2020;

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기 {
	static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		Map<Integer, Point> keypad = new HashMap<>();
		keypad.put(1, new Point(0, 0));	keypad.put(2, new Point(0, 1));	keypad.put(3, new Point(0, 2));
		keypad.put(4, new Point(1, 0));	keypad.put(5, new Point(1, 1));	keypad.put(6, new Point(1, 2));
		keypad.put(7, new Point(2, 0));	keypad.put(8, new Point(2, 1));	keypad.put(9, new Point(2, 2));
		keypad.put(0, new Point(3, 1));

		Point rightHand = new Point(3, 2);	// 오른손의 현재 위치
		Point leftHand = new Point(3, 0);	// 왼손의 현재 위치

		Point now;	// 번호의 위치
		for (int number : numbers) {
			now = keypad.get(number);

			if (now.y == 1) {	// 번호가 가운데 위치 한 경우
				int rightDistance = Math.abs(now.x - rightHand.x) + Math.abs(now.y - rightHand.y);	// 오른손에서 현재 번호까지의 거리
				int leftDistance = Math.abs(now.x - leftHand.x) + Math.abs(now.y - leftHand.y);		// 왼손에서 현재 번호까지의 거리

				if (rightDistance > leftDistance) {
					answer.append("L");
					leftHand = now;
				} else if (rightDistance < leftDistance) {
					answer.append("R");
					rightHand = now;
				} else {
					if (hand.equals("right")) {
						answer.append("R");
						rightHand = now;
					} else {
						answer.append("L");
						leftHand = now;
					}
				}
			} else if (now.y == 0) {	// 번호가 왼쪽에 위치 한 경우
				answer.append("L");
				leftHand = now;
			} else {					// 번호가 오른쪽에 위치 한 경우
				answer.append("R");
				rightHand = now;
			}
		}

		return answer.toString();
	}

	public static void main(String[] args) {

	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
