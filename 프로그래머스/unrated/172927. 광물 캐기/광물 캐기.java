import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        Map<String, Integer> mineralTypeMap = new HashMap<>();
        mineralTypeMap.put("diamond", 0);
        mineralTypeMap.put("iron", 1);
        mineralTypeMap.put("stone", 2);

int pickCount = picks[0] + picks[1] + picks[2];

        int[][] costs = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        List<MineralGroup> groups = new ArrayList<>();

        MineralGroup group = new MineralGroup();

        for (int i = 0; i < minerals.length; ++i) {
            int mineralType = mineralTypeMap.get(minerals[i]);

            group.totalCost += costs[2][mineralType];
            group.minerals.add(mineralType);

            if (group.minerals.size() == 5) {
                groups.add(group);
                group = new MineralGroup();
            }

            if (groups.size() == pickCount) break;
        }

        groups.add(group);
        groups.sort((g1, g2) -> g2.totalCost - g1.totalCost);

        int index = 0;

        for (int i = 0; i < picks.length; ++i) {
            for (int j = 0; j < picks[i]; ++j) {
                if (index >= groups.size()) break;
                for (int type : groups.get(index).minerals) {
                    answer += costs[i][type];
                }
                ++index;
            }
        }

        return answer;
    }

    class MineralGroup {

        int totalCost;

        List<Integer> minerals;

        public MineralGroup() {
            minerals = new ArrayList<>();
        }
    }
}