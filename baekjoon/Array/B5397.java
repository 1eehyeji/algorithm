package baekjoon.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* 백준 5397번 키로거
 *
 * 강산이가 비밀번호 창에서 입력한 키가 주어졌을 때,
 * 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.
 *
 * 첫째 줄에 테스트 케이스의 개수가 주어진다.
 * 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000)
 * 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다.
 * 화살표의 입력은 '<'와 '>'로 주어진다. 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다.
 * 나머지 문자는 비밀번호의 일부이다.
 *
 *
 * ListIterator 를 사용하여 구현
 * ArrayList 로 구현할 경우 시간초과
 * */
public class B5397 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String password = br.readLine();
			List<Character> list = new LinkedList<>();
			ListIterator<Character> listIterator = list.listIterator();

			for (char c : password.toCharArray()) {

				switch (c) {
					case '-':
						if (listIterator.hasPrevious()) {
							listIterator.previous();
							listIterator.remove();
						}
						break;
					case '<':
						if (listIterator.hasPrevious()) {
							listIterator.previous();
						}
						break;
					case '>':
						if (listIterator.hasNext()) {
							listIterator.next();
						}
						break;
					default:
						listIterator.add(c);
				}
			}

			StringBuilder sb = new StringBuilder();

			for (char c : list) {
				sb.append(c);
			}

			bw.write(sb.toString() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
