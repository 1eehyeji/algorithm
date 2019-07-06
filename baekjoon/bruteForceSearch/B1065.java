package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 백준 1065번 한수
*  어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
*  등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
*  N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
*
*  1부터 99까지는 모든 수가 등차수열을 이룸
*  1000은 등차수열을 이루지 않으니 1000이 주어진 경우 999로 초기화함
*  문제를 억지로 해결한 느낌, 조금 더 고민하고 다시 해결해볼 예정
*  메소드 이름도 하는 역할이 명확하게 나타나지 않으니 수정
 * */
public class B1065 {

    public static boolean check(int m) {    // 각 자리수를 리스트에 저장함
        List<Integer> list = new ArrayList<>();

        while (m > 0) {
            list.add(m % 10);
            m /= 10;
        }

        return solution(list);
    }

    public static boolean solution(List<Integer> list){    // 주어진 값이 세자리라는 가정하에 각 자리수가 등차수열을 이루는지 검사함
        int num1 = list.get(1) - list.get(0);
        int num2 = list.get(2) - list.get(1);

        return num1 == num2 ? true : false;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n < 100) {   // n이 두 자리 수일 경우 n개의 한수를 가진다.
            System.out.println(n);
            return;
        } else if(n == 1000){   // n이 1000일 경우 999로 초기화하여 한수 개수를 구한다. 맨 위 주석 참고
            n = 999;
        }

        int count = 99; // 1 ~ 99까지는 모두 한수이다.

        for(int i = 100; i <= n; ++i) {
            if(check(i)) {      // i값이 한수인지 검사하여 한수가 맞을 경우 count가 1씩 증가
                ++count;
            }
        }

        System.out.println(count);
    }
}
