package baekjoon.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 10039번 평균 점수
*  기말고사 점수가 40점 이상인 학생들은 그 점수 그대로 자신의 성적이 된다.
*  하지만, 40점 미만인 학생들은 보충학습을 듣는 조건을 수락하면 40점을 받게 된다.
*  보충학습은 거부할 수 없기 때문에, 40점 미만인 학생들은 항상 40점을 받게 된다.
*  학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성하시오.
*  점수는 모두 0점 이상, 100점 이하인 5의 배수이다. 따라서, 평균 점수는 항상 정수이다.
*/
public class B10039 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        for(int i = 0; i < 5; ++i) {
            int score = Integer.parseInt(br.readLine());
            answer += (score < 40 ? 40 : score);
        }

        System.out.println(answer / 5);
    }
}
