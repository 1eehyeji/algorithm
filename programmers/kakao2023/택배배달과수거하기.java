package programmers.kakao2023;

public class 택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int[] sumOfDeliveries = deliveries;
        int[] sumOfPickups = pickups;

        for (int i = n - 2; i >= 0; --i) {
            sumOfDeliveries[i] = sumOfDeliveries[i + 1] + sumOfDeliveries[i];
            sumOfPickups[i] = sumOfPickups[i + 1] + sumOfPickups[i];
        }

        int visitCount = 0;
        int sumCap = 0;

        while (--n >= 0) {
            int maxBox = Math.max(sumOfDeliveries[n], sumOfPickups[n]);

            if (maxBox > sumCap) {
                visitCount = (int) Math.ceil((double) (maxBox - sumCap) / cap);
                sumCap += cap * visitCount;
                answer += (long) (n + 1) * visitCount;
            }
        }

        return answer * 2;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
    }
}
