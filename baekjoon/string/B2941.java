package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 2941번 크로아티아 알파벳
* 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
* 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
* 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다
* 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
* dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
* lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
* 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
* */
public class B2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		String[] croatianAlphabet = { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };
		//int countAlphabet = 0;

		for(String s : croatianAlphabet) {
			while (word.contains(s)) {	// 문자열에 해당 크로아티아 알파벳이 포함되어 있으면 반복
				word = word.replaceFirst(s, " ");		// 공백처리

				//++countAlphabet;
			}
		}

		/*for(int i = 0; i < word.length(); ++i) { // 남은 알파벳 개수
			if(word.charAt(i) != ' ') {
				++countAlphabet;
			}
		}*/

		System.out.println(word.length());

		br.close();
	}
}
