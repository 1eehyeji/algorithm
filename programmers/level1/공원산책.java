package programmers.level1;

public class 공원산책 {

    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        for (int i = 0;  i < park.length; ++i) {
            for (int j = 0; j < park[i].length(); ++j) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        for (String route : routes) {
            String[] token = route.split(" ");
            int n = Integer.parseInt(token[1]);

            int nowX = x;
            int nowY = y;
            for (int i = 0; i < n; ++i) {
                if (token[0].equals("N")) {
                    --nowX;
                }
                if (token[0].equals("S")) {
                    ++nowX;
                }
                if (token[0].equals("W")) {
                    --nowY;
                }
                if (token[0].equals("E")) {
                    ++nowY;
                }

                if (nowX < 0 || nowX >= park.length ||
                        nowY < 0 || nowY >= park[nowX].length() ||
                        park[nowX].charAt(nowY) == 'X') {
                    nowX = x;
                    nowY = y;
                    break;
                }
            }

            x = nowX;
            y = nowY;
        }

        return new int[] {x, y};
    }
}
