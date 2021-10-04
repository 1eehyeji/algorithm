package programmers;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;

        for (int[] size : sizes) {
            wMax = Math.max(wMax, Math.max(size[0], size[1]));
            hMax = Math.max(hMax, Math.min(size[0], size[1]));
        }

        return wMax * hMax;
    }

    public static void main(String[] args) {
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        System.out.println(solution(sizes));
    }
}
