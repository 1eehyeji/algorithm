package programmers.level2;

import java.util.Arrays;

public class 호텔대실 {

    public int solution(String[][] book_time) {
        int[] count = new int[1440];

        for (String[] time : book_time) {
            String[] start = time[0].split(":");
            int startIndex = (Integer.parseInt(start[0]) * 60) + Integer.parseInt(start[1]);
            String[] end = time[1].split(":");
            int endHour = Integer.parseInt(end[0]);
            int endMinute = Integer.parseInt(end[1]) + 10;

            endHour += endMinute / 60;
            endMinute = endMinute % 60;

            int endIndex = Math.min((endHour * 60) + endMinute, count.length);

            for (int i = startIndex; i < endIndex; ++i) {
                ++count[i];
            }
        }

        return Arrays.stream(count).max().getAsInt();
    }
}
