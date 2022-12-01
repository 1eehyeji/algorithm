package programmers.kakao2022;

import java.util.Arrays;

public class 양궁대회 {

    int maxDistance = 0;
    int[] rionScore;

    public int[] solution(int n, int[] info) {
        rionScore = new int[info.length];

        dfs(n, info, new int[info.length], 10);

        if (maxDistance <= 0) {
            return new int[]{-1};
        }

        return rionScore;
    }

    private void dfs(int n, int[] info, int[] score, int point) {
        if (point == 0 && n > 0) {
            score[score.length - 1] = n;
            n = 0;
        }

        // 화살을 다 소진한 경우 점수 계산
        if (n <= 0) {
            // 어피치와 라이언의 점수를 계산한다.
            int distance = getDistance(info, score);

            // 점수차가 maxDistance보다 큰 경우 해당 스코어를 저장한다.
            if (distance >= maxDistance) {
                // 점수 차가 같은 경우 가장 작은 점수를 더 많이 맞춘 스코어를 저장한다.
                if (distance == maxDistance) {
                    for (int i = score.length - 1; i >= 0; --i) {
                        if (rionScore[i] > score[i]) {
                            break;
                        }

                        if (rionScore[i] < score[i]) {
                            rionScore = score;
                            break;
                        }
                    }
                    return;
                }

                maxDistance = distance;
                rionScore = score;
            }

            return;
        }

        // 맞추지 않는 경우
        // + 어피치가 맞춘 화살 개수보다 남은 화살 개수가 적은 경우
        dfs(n, info, Arrays.copyOf(score, score.length), point - 1);

        int index = 10 - point;
        int countOfApeachArrow = info[index];
        // 어피치보다 한 번 더 맞추는 경우
        // + 어피치가 맞춘 화살 개수보다 남은 화살 개수가 많거나 같은 경우
        if (countOfApeachArrow + 1 <= n) {
            score[index] = countOfApeachArrow + 1;
            dfs(n - (countOfApeachArrow + 1), info, Arrays.copyOf(score, score.length), point - 1);
        }
    }

    private int getDistance(int[] apeach, int[] rion) {
        int apeachTotalScore = 0;
        int rionTotalScore = 0;

        for (int i = 0; i < apeach.length; ++i) {
            if (apeach[i] == 0 && rion[i] == 0) {
                continue;
            }

            if (apeach[i] >= rion[i]) {
                apeachTotalScore += (10 - i);
                continue;
            }

            rionTotalScore += (10 - i);
        }

        return rionTotalScore - apeachTotalScore;
    }

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        양궁대회 competition = new 양궁대회();

        System.out.println(Arrays.toString(competition.solution(n, info)));
    }
}
