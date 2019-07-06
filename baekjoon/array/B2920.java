package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 2920번 음계
*  1부터 8까지 차례대로 연주한다면 ascending,
*  8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
*  연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지,
*  아니면 mixed인지 판별하는 프로그램을 작성하시오.
*  첫째 줄에 8개 숫자가 주어진다.
*  이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
*/
public class B2920 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        String ascending = "1 2 3 4 5 6 7 8";
        String descending = "8 7 6 5 4 3 2 1";

        if(ascending.equals(input)) {
            System.out.println("ascending");
        }
        else if(descending.equals(input)) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }

        br.close();
    }
}
