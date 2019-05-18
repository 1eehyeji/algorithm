package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 1475번 방 번호
 *
 * 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
 * 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
 * (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
 *
 * 첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
 */
public class B1475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String roomNumber = br.readLine();

		int[] numbers = new int[10];

		for (int i = 0; i < roomNumber.length(); ++i) {
			int index = Integer.parseInt(roomNumber.charAt(i) + "");
			++numbers[index];
		}

		int max = Integer.MIN_VALUE;

		numbers[6] = (int) Math.ceil((numbers[6] + numbers[9]) / 2.0);

		for (int i = 0; i < numbers.length - 1; ++i) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}

		System.out.println(max);
	}
}
