package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; ++i) {
            map.put(players[i], i);
        }

        for (String name : callings) {
            int rank = map.get(name);

            String temp = players[rank - 1];
            players[rank - 1] = name;
            players[rank] = temp;

            map.put(temp, rank);
            map.put(name, rank - 1);
        }

        return players;
    }
}
