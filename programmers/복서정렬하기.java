package programmers;

import java.util.Arrays;

public class 복서정렬하기 {

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        Boxer[] boxers = new Boxer[weights.length];

        for (int i = 0; i < weights.length; ++i) {
            int count = 0;
            int countOfWin = 0;
            int countOfWinHeavier = 0;
            for (int j = 0; j < head2head[i].length(); ++j) {
                char c = head2head[i].charAt(j);
                if (c == 'N')
                    continue;
                ++count;
                if (c == 'W') {
                    ++countOfWin;
                    if (weights[i] < weights[j])
                        ++countOfWinHeavier;
                }
            }
            boxers[i] = new Boxer(i + 1, weights[i], (countOfWin / (float) count) * 100, countOfWinHeavier);
            System.out.println(boxers[i].toString());
        }

        Arrays.sort(boxers);
        for (int i = 0; i < boxers.length; ++i) {
            answer[i] = boxers[i].number;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] weight = {50, 82, 75, 120};
        String[] head2head = {"NLWL", "WNLL", "LWNW", "WWLN"};

        System.out.println(Arrays.toString(solution(weight, head2head)));
    }
}

class Boxer implements Comparable<Boxer> {

    int number;
    int weight;
    float winRate;
    int countOfWinHeavier;

    public Boxer(int number, int weight, float winRate, int countOfWinHeavier) {
        this.number = number;
        this.weight = weight;
        this.winRate = winRate;
        this.countOfWinHeavier = countOfWinHeavier;
    }

    @Override
    public int compareTo(Boxer boxer) {
        if (this.winRate > boxer.winRate) return -1;
        else if (this.winRate < boxer.winRate) return 1;

        if (this.countOfWinHeavier > boxer.countOfWinHeavier) return -1;
        else if (this.countOfWinHeavier < boxer.countOfWinHeavier) return 1;

        if (this.weight > boxer.weight) return -1;
        else if (this.weight < boxer.weight) return 1;

        return this.number - boxer.number;
    }

    @Override
    public String toString() {
        return this.number + " " + this.weight + " " + this.winRate + " " + this.countOfWinHeavier;
    }
}
