package programmers.kakao2021;

import java.util.Arrays;

public class 광고삽입 {

    public static String solution(String play_time, String adv_time, String[] logs) {
        long[] times = new long[getSeconds(play_time) + 1];

        for (String log : logs) {
            String[] tokens = log.split("-");
            times[getSeconds(tokens[0])] += 1;
            times[getSeconds(tokens[1])] -= 1;
        }

        for (int i = 1; i < times.length; ++i) {
            times[i] += times[i - 1];
        }

        for (int i = 1; i < times.length; ++i) {
            times[i] += times[i - 1];
        }

        int advTime = getSeconds(adv_time);
        long maxView = times[advTime - 1];
        long maxViewTime = 0;
        for (int i = 0; i + advTime < times.length; ++i) {
            long v = times[i + advTime] - times[i];
            if (v > maxView) {
                maxView = v;
                maxViewTime = i + 1;
            }
        }

        return timeToString(maxViewTime);
    }

    private static String timeToString(long time) {
        String result = "";

        int hour = (int) (time / 3600);
        time %= 3600;
        result += (hour < 10 ? "0" + hour : hour) + ":";

        int minute = (int) (time / 60);
        time %= 60;
        result += (minute < 10 ? "0" + minute : minute) + ":";

        return result + (time < 10 ? "0" + time : time);
    }

    static int getSeconds(String time) {
        String[] tokens = time.split(":");
        return (Integer.parseInt(tokens[0]) * 3600) + (Integer.parseInt(tokens[1]) * 60) + Integer.parseInt(tokens[2]);
    }

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {
                "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
        };

        System.out.println(solution(play_time, adv_time, logs));
    }
}
