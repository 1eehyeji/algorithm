package programmers;



import java.util.*;



public class 문자열내맘대로정렬하기 {
	static String[] solution(String[] strings, int n) {
		List<String> list = Arrays.asList(strings);

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char c1 = o1.charAt(n);
				char c2 = o2.charAt(n);

				if (c1 != c2) {
					return c1 - c2;
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		return list.stream().toArray(String[]::new);
	}

	public static void main(String[] args) {
		String[] arr = {"abce", "abcd", "cdx"};

		System.out.println(Arrays.toString(solution(arr, 1)));
	}
}
