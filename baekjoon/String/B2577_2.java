package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*백준 2577 숫자의 개수
 * 세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지
 * 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고,
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 *
 * 입력 값으로 자연수만 들어오기 때문에 곱셈 결과가 0인 경우를 신경쓰지 않아도 괜찮음
 * */
public class B2577_2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int multiply = A * B * C;

        int[] count = new int[10];

        while(multiply > 0) {
            ++count[multiply % 10];
            multiply /= 10;
        }

        for (int i : count) {
            System.out.println(i);
        }
    }
}
