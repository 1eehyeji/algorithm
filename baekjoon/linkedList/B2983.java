package baekjoon.linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 2983번 개구리 공주 (https://www.acmicpc.net/problem/2983)
 *
 * Map 과 ArrayList 로 구현
 * 선형 탐색으로 구현할 경우 시간 초과 발생
 */
public class B2983 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String directions = br.readLine();

		Map<Integer, ArrayList<Point>> xMinusY = new HashMap<>();
		Map<Integer, ArrayList<Point>> xPlusY = new HashMap<>();

		Point currentPoint = null;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			Point point = new Point(x, y);

			if (i == 0) {
				currentPoint = point;
			}

			addPoint(xMinusY, xPlusY, point);
		}

		sort(xMinusY);
		sort(xPlusY);

		for (char c : directions.toCharArray()) {
			ArrayList<Point> list1 = xMinusY.get(currentPoint.getXMinusY());
			ArrayList<Point> list2 = xPlusY.get(currentPoint.getXPlusY());

			int index1 = Collections.binarySearch(list1, currentPoint);
			int index2 = Collections.binarySearch(list2, currentPoint);

			Point nextPoint = null;

			if (c == 'A' && (index1 < list1.size() - 1) || c == 'D' && (index1 > 0)) {
				nextPoint = list1.get(index1 + (c == 'A' ? 1 : -1));
				list1.remove(index1);
				list2.remove(index2);
			} else if (c == 'B' && (index2 < list2.size() - 1) || c == 'C' && (index2 > 0)) {
				nextPoint = list2.get(index2 + (c == 'B' ? 1 : -1));
				list1.remove(index1);
				list2.remove(index2);
			}

			currentPoint = nextPoint != null ? nextPoint : currentPoint;
		}

		System.out.println(currentPoint.x + " " + currentPoint.y);
	}

	public static void sort(Map<Integer, ArrayList<Point>> map) {
		for (Integer i : map.keySet()) {
			Collections.sort(map.get(i));
		}
	}

	public static void addPoint(Map<Integer, ArrayList<Point>> xMinusY, Map<Integer, ArrayList<Point>> xPlusY,
								Point point) {
		int keyXMinusY = point.getXMinusY();
		int keyXPlusY = point.getXPlusY();

		ArrayList<Point> list1 = xMinusY.get(keyXMinusY);

		if (list1 == null) {
			list1 = new ArrayList<>();
			xMinusY.put(keyXMinusY, list1);
		}
		list1.add(point);

		ArrayList<Point> list2 = xPlusY.get(keyXPlusY);

		if (list2 == null) {
			list2 = new ArrayList<>();
			xPlusY.put(keyXPlusY, list2);
		}
		list2.add(point);
	}
}

class Point implements Comparable<Point> {

	long x;

	long y;

	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public int getXMinusY() {
		return (int) (x - y);
	}

	public int getXPlusY() {
		return (int) (x + y);
	}

	@Override
	public int compareTo(Point o) {
		int r = (int) (this.x - o.x);

		if (r != 0) {
			return r;
		}

		return (int) (this.y - o.y);
	}
}