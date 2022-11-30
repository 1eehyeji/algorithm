package programmers;

public class 숫자카드나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int aGCD = getGCDOfCards(arrayA);
        int bGCD = getGCDOfCards(arrayB);

        return Math.max(isDivisorOfCards(aGCD, arrayB) ? 0 : aGCD,
                isDivisorOfCards(bGCD, arrayA) ? 0 : bGCD);
    }

    public int getGCDOfCards(int[] cards) {
        int GCD = cards[0];

        for(int i = 1; i < cards.length; ++i) {
            GCD = GCD(GCD, cards[i]);
        }

        return GCD;
    }

    public boolean isDivisorOfCards(int n, int[] cards) {
        for (int card : cards) {
            if (card % n == 0) {
                return true;
            }
        }

        return false;
    }

    public int GCD(int n, int m) {
        while(m != 0) {
            int temp = n;
            n = m;
            m = temp % m;
        }

        return n;
    }
}
