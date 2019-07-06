package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B11651 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class ComparatorPoint2 implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
			if(o1.y > o2.y) return 1;
			else if(o1.y == o2.y) {
				if(o1.x > o2.x) return 1;
				else return -1;
			}
			return -1;
		}

	}
	public static void main(String[] args) throws Exception{

		List<Point> list = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		String[] s;
		Point point;

		for(int i = 0; i < size; ++i) {
			s = br.readLine().split(" ");
			point = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			list.add(point);
		}

		Collections.sort(list, new ComparatorPoint2());

		for(Point p : list) {
			System.out.println(p.x + " " + p.y);
		}

		br.close();
	}
}
