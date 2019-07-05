package baekjoon.dequeue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/* 백준 5430번 AC
*
* 함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다.
* 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
*
* 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다.
* 만약, 에러가 발생한 경우에는 error 를 출력한다.
*
* [풀이 과정]
* R 함수가 호출되는 만큼 순서를 뒤집으면 시간초과가 발생하였다.
* 그래서 R 함수가 호출되는 횟수를 세고, 마지막에 검사하여 순서를 뒤집을지 결정하였다.
* 몇번 틀리고나서야 출력 값이 .toString 한 결과와 다르다는 것을 알게 되었다.
* 그래서 출력 값을 만들어주는 메소드를 따로 구현하여 문제를 해결했다.
 */
public class B5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T --> 0) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());

			String array = br.readLine();
			StringTokenizer st = new StringTokenizer(array.substring(1, array.length() - 1), ",");

			ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

			for (int i = 0; i < N; ++i) {
				arrayDeque.addLast(Integer.parseInt(st.nextToken()));
			}

			String result = "";

			try {
				int countR = 0;

				for (char c : P.toCharArray()) {

					if (c == 'R') {
						++countR;
					} else if (c == 'D') {
						if (arrayDeque.isEmpty()) {
							throw new RuntimeException();
						}

						if (countR % 2 == 0) {
							arrayDeque.removeFirst();
						} else {
							arrayDeque.removeLast();
						}
					}
				}

				if (countR % 2 != 0) {
					arrayDeque = reverseOrder(arrayDeque);
				}

				result = dequeToString(arrayDeque);

			} catch (RuntimeException e) {
				result = "error";

			} finally {
				bw.write(result);
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static String dequeToString(ArrayDeque<Integer> arrayDeque) {
		StringJoiner joiner = new StringJoiner(",");

		while (arrayDeque.size() != 0) {
			joiner.add(arrayDeque.pollFirst().toString());
		}

		return "[" + joiner.toString() + "]";
	}

	public static ArrayDeque<Integer> reverseOrder(ArrayDeque<Integer> arrayDeque) {
		ArrayDeque<Integer> reversedDeque = new ArrayDeque<>();

		while (arrayDeque.size() != 0) {
			reversedDeque.addLast(arrayDeque.pollLast());
		}

		return reversedDeque;
	}
}
