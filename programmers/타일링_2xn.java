package programmers;

public class 타일링_2xn {

    public static int solution(int n) {
        int[] tileCounts = new int[n + 1];
        tileCounts[1] = 1;
        tileCounts[2] = 2;

        for (int i = 3; i <= n; ++i) {
            tileCounts[i] = (tileCounts[i - 2] + tileCounts[i - 1]) % 1000000007;
        }

        return tileCounts[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}

