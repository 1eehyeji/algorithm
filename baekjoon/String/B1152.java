package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 백준 1152번 단어의 개수
 * 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다.
 * 이 문자열에는 몇 개의 단어가 있을까?이를 구하는 프로그램을 작성하시오.
 * 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 * 첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다.
 * 이 문자열의 길이는 1,000,000을 넘지 않는다.
 * 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
 * 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
 *
 * StringTokenizer을 사용하여 공백을 기준으로 문자열을 자르고,
 * countTokens 메소드를 사용하여 개수를 출력*/
public class B1152 {

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        System.out.println(st.countTokens());
    }
}
