package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 백준 1316번 그룹 단어 체커
* 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
* 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
* kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
* aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
* 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*
* 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
* 둘째 줄부터 N개의 줄에 단어가 들어온다.
* 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 * */
public class B1316 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int countGroup = 0;

		while (N --> 0) {
			String word = br.readLine();
			boolean check = true;	// 그룹 단어인지 체크

			for (int i = 0; i < word.length(); ++i) {
				String s = word.substring(i, i+1);
				int first = word.indexOf(s);
				int last = word.lastIndexOf(s);

				if(first == last) {	// 단어에서 s가 한개만 존재하는 경우
					continue;
				}

				int num = last - first;
				if(num == 1) {	// s가 바로 옆에 붙어있는 경우
					continue;
				}
				else {	// s가 그룹을 이루고 있는지 검사
					char[] c = new char[num];
					Arrays.fill(c, s.charAt(0));
					if(!word.substring(first, last).equals(String.valueOf(c))) {
						check = false;
					}
				}
			}

			if(check) {	// 모든 문자가 그룹을 이루고 있는 경우
				++countGroup;
			}
		}

		br.close();

		System.out.println(countGroup);
	}
}
