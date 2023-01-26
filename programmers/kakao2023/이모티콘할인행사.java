package programmers.kakao2023;

public class 이모티콘할인행사 {

    static int[] discountRates = {10, 20, 30, 40};

    int maxCountOfEmoticonPlusUser;
    int maxCostOfEmoticon;

    public int[] solution(int[][] users, int[] emoticons) {
        maxCountOfEmoticonPlusUser = 0;
        maxCostOfEmoticon = 0;

        calculateMaxProfit(emoticons, users, 0, new int[emoticons.length]);

        return new int[] {maxCountOfEmoticonPlusUser, maxCostOfEmoticon};
    }

    private void calculateMaxProfit(int[] emoticons, int[][] users, int index, int[] discountInfo) {
        if (index == emoticons.length) {
            // 할인율을 적용하여 각 사용자의 구매여부와 이모티콘 플러스 가입 여부를 확인
            int countOfEmoticonPlusUser = 0;
            int costOfEmoticon = 0;

            for (int[] user : users) {
                int cost = 0;

                for (int i = 0; i < emoticons.length; ++i) {
                    if (user[0] > discountInfo[i]) {
                        continue;
                    }

                    cost += emoticons[i] * (100 - discountInfo[i]) / 100;

                    if (cost >= user[1]) {
                        ++countOfEmoticonPlusUser;
                        cost = 0;
                        break;
                    }
                }

                costOfEmoticon += cost;
            }

            // max 갱신
            if (countOfEmoticonPlusUser == maxCountOfEmoticonPlusUser) {
                maxCostOfEmoticon = Math.max(maxCostOfEmoticon, costOfEmoticon);
                return;
            }

            if (countOfEmoticonPlusUser > maxCountOfEmoticonPlusUser) {
                maxCountOfEmoticonPlusUser = countOfEmoticonPlusUser;
                maxCostOfEmoticon = costOfEmoticon;
                return;
            }

            return;
        }

        for (int discountRate : discountRates) {
            discountInfo[index] = discountRate;
            calculateMaxProfit(emoticons, users, index + 1, discountInfo);
        }
    }
}
