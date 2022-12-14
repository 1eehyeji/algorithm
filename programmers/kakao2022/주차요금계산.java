package programmers.kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkedCarMap = new HashMap<>();
        Map<String, Integer> totalParkingTimeMap = new HashMap<>();

        for (String record : records) {
            String[] recordToken = record.split(" ");
            
            if (recordToken[2].equals("IN")) {
                parkedCarMap.put(recordToken[1], convertTimeStringToMinute(recordToken[0]));
                continue;
            }

            int parkingTime = totalParkingTimeMap.getOrDefault(recordToken[1], 0)
                    + (convertTimeStringToMinute(recordToken[0]) - parkedCarMap.get(recordToken[1]));
            totalParkingTimeMap.put(recordToken[1], parkingTime);
            parkedCarMap.remove(recordToken[1]);
        }

        for (Map.Entry<String, Integer> parkedCar : parkedCarMap.entrySet()) {
            int parkingTime = totalParkingTimeMap.getOrDefault(parkedCar.getKey(), 0)
                    + (convertTimeStringToMinute("23:59") - parkedCar.getValue());
            totalParkingTimeMap.put(parkedCar.getKey(), parkingTime);
        }

        int[] answer = new int[totalParkingTimeMap.size()];
        List<String> sortedCarNumber = totalParkingTimeMap.keySet().stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < sortedCarNumber.size(); ++i) {
            answer[i] = getTotalFee(fees, totalParkingTimeMap.get(sortedCarNumber.get(i)));
        }

        return answer;
    }

    private Integer getTotalFee(int[] fees, int parkingTime) {
        int basicTime = fees[0];
        int basicRate = fees[1];
        int unitTime = fees[2];
        int unitRate = fees[3];

        if (parkingTime <= basicTime) {
            return basicRate;
        }

        return basicRate + ((int) Math.ceil((double) (parkingTime - basicTime) / unitTime) * unitRate);
    }

    private int convertTimeStringToMinute(String time) {
        String[] timeToken = time.split(":");

        int hour = Integer.parseInt(timeToken[0]);
        int minute = Integer.parseInt(timeToken[1]);

        System.out.println((hour * 60) + minute);

        return (hour * 60) + minute;
    }

    public static void main(String[] args) {
        주차요금계산 solution = new 주차요금계산();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution.solution(fees, records)));
    }
}

