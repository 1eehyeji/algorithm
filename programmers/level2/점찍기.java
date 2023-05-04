package programmers.level2;

public class 점찍기 {

    public long solution(int k, int d) {
        long answer = 0;

        for (int a = 0; (a * k) <= d; ++a) {
            // 0에서 y 값 사이 k의 배수의 개수 + 1(= y가 0인 경우)
            answer += (getMaxY((a * k), d) / k) + 1;
        }

        return answer;
    }

    // 원의 반지름 d를 이용해 원 안에 들어가는 점을 찍는 문제
    // x^2 + y^2 <= d^2 공식을 사용하여 x값이 주어졌을 때 y의 가장 큰 값을 구할 수 있음
    private int getMaxY(int x, int d) {
        return (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
    }
}
