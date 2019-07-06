package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 5622번 다이얼
*
* 숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며,
* 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
* 상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다.
* 할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오.
* 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
 * */
public class B5622 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		int[] number = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };	//알파벳에 해당하는 숫자
		int time = 0;

		for(int i = 0; i < word.length(); ++i) {
			time += number[word.charAt(i) - 65] + 1;	//해당 알파벳의 숫자에 1을 더한 만큼 시간이 걸림
		}

		System.out.println(time);

		br.close();
	}
}
