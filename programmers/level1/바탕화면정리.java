package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; ++i) {
            for (int j = 0; j < wallpaper[i].length(); ++j) {
                if (wallpaper[i].charAt(j) == '#') {
                    xList.add(i);
                    yList.add(j);
                }
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        return new int[] {xList.get(0), yList.get(0), xList.get(xList.size() - 1) + 1, yList.get(yList.size() - 1) + 1};
    }
}
