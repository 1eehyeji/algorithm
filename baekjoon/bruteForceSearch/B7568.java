package baekjoon.bruteForceSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 7568번 덩치 (https://www.acmicpc.net/problem/7568)
public class B7568 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Person> personList = new ArrayList<>();

		while (N --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			personList.add(new Person(weight, height));
		}

		br.close();

		for (int i = 0; i < personList.size(); ++i) {
			Person person1 = personList.get(i);
			for (int j = 0; j < personList.size(); ++j) {
				if (i != j) {
					Person person2 = personList.get(j);

					if (isSmaller(person1, person2)) {
						++person1.rank;
					}
				}
			}
		}

		personList.stream().forEach(p -> System.out.print((p.rank + 1) + " "));
	}

	static boolean isSmaller(Person p1, Person p2) {
		return p1.weight < p2.weight && p1.height < p2.height;
	}
}

class Person {

	int weight;
	int height;
	int rank;

	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
		this.rank = 0;
	}
}