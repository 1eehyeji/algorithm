package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {
	static String solution(int[] numbers) {
		List<String> list = new ArrayList<>();

		for (int i : numbers) {
			list.add(String.valueOf(i));
		}

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		if (list.get(0).equals("0")) {
			return "0";
		}

		return String.join("",list);
	}
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};

		System.out.println(solution(numbers));
	}
}
