package baekjoon.math;

import java.util.ArrayList;
import java.util.List;

/* 백준 4673번 셀프 넘버
 * 3으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다.
 * 이런식으로 다음과 같은 수열을 만들 수 있다.
 * n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다.
 * 생성자가 없는 숫자를 셀프 넘버라고 한다.
 * 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 *
 * 미리 리스트에 1 ~ 10000까지 담아두고 생성자가 있는 수의 경우 삭제하여 리스트에 셀프 넘버만 남도록 구현함
 * 수가 10000보다 커질 경우엔 다른 방식으로 구현을 해야할 것 같음
 *  */
public class B4673 {

    public static Integer solution(Integer n) { //n과 n의 각 자리수를 더하는 함수
        Integer num = n;
        while (n > 0) {
            num += (n % 10);
            n /= 10;
        }
        return num;
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 10000; ++i) {   // 1 ~ 10000까지 리스트에 저장해둠
            list.add(i);
        }

        for(int j = 1; j <= 10000; ++j) {   // 생성자가 존재하는 수는 리스트에서 삭제함
            list.remove(solution(j));
        }

        for(Integer i : list) {     // 리스트에 남아있는 수를 출력
            System.out.println(i);
        }
    }
}