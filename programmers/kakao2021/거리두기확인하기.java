package programmers.kakao2021;

import java.util.Arrays;

public class 거리두기확인하기 {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; ++i) {
            answer[i] = checkSocialDistancing(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private static boolean checkSocialDistancing(String[] place) {
        int[][] point = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] distances = new int[place.length][place[0].length()];
        String[][] seats = new String[place.length][place[0].length()];

        for (int i = 0; i < place.length; ++i) {
            char[] arr = place[i].toCharArray();

            for (int j = 0; j < seats.length; ++j) {
                seats[i][j] = String.valueOf(arr[j]);
            }
        }

        for (int i = 0; i < seats.length; ++i) {
            for (int j = 0; j < seats[i].length; ++j) {
                if (!seats[i][j].equals("P")) continue;

                for (int[] p : point) {
                    int x = i + p[0];
                    int y = j + p[1];

                    if (x < 0 || x >= seats.length || y < 0 || y >= seats[i].length) continue;

                    String s = seats[x][y];

                    if (s.equals("P")) return false;

                    if (s.equals("O") && ++distances[x][y] > 1) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(solution(places)));
    }
}
