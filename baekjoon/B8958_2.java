package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*백준 8958 OX퀴즈
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * */
public class B8958_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            String s = br.readLine();

            int count = 0;
            int total = 0;

            for (int i = 0; i < s.length(); ++i) {

                char c = s.charAt(i);

                if(c == 'O') {
                    ++count;
                    total += count;
                } else {
                    count = 0;
                }

            }

            System.out.println(total);
        }

        br.close();
    }
}
