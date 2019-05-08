package codingTest.N0413;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	static int max = 0;

	public static int solution(Tree T) {
		List<Integer> list = new ArrayList<>();
		solution(T, list);
		return max;
	}

	public static void solution(Tree T, List<Integer> list) {
		if (!list.contains(T.x)) {
			list.add(T.x);
		}

		if (T.r == null && T.l == null) {
			max = Math.max(max, list.size());
			return;
		}

		if (T.l != null) {
			solution(T.l, new ArrayList<>(list));
		}
		if (T.r != null) {
			solution(T.r, new ArrayList<>(list));
		}

	}

	public static void main(String[] args) {

		Tree g = new Tree(5, null, null); // 문제 그림의 트리 구현
		Tree d = new Tree(4, g, null);
		Tree b = new Tree(5, d, null);
		Tree e = new Tree(1, null, null);
		Tree f = new Tree(6, null, null);
		Tree c = new Tree(6, e, f);
		Tree a = new Tree(4, b, c);

		System.out.println(solution(a));

	}

}

class Tree {

	int x;

	Tree l;
	Tree r;

	public Tree(int x, Tree l, Tree r) {
		this.x = x;
		this.l = l;
		this.r = r;
	}
}