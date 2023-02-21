package softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 전광판 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, int[]> map = new HashMap();
        map.put("0", new int[]{1, 1, 1, 0, 1, 1, 1});
        map.put("1", new int[]{0, 0, 1, 0, 0, 1, 0});
        map.put("2", new int[]{1, 0, 1, 1, 1, 0, 1});
        map.put("3", new int[]{1, 0, 1, 1, 0, 1, 1});
        map.put("4", new int[]{0, 1, 1, 1, 0, 1, 0});
        map.put("5", new int[]{1, 1, 0, 1, 0, 1, 1});
        map.put("6", new int[]{1, 1, 0, 1, 1, 1, 1});
        map.put("7", new int[]{1, 1, 1, 0, 0, 1, 0});
        map.put("8", new int[]{1, 1, 1, 1, 1, 1, 1});
        map.put("9", new int[]{1, 1, 1, 1, 0, 1, 1});
        map.put(" ", new int[]{0, 0, 0, 0, 0, 0, 0});

        while (N-- > 0) {
            String[] arr = br.readLine().split(" ");
            String s1 = String.format("%5s", arr[0]);
            String s2 = String.format("%5s", arr[1]);

            int count = 0;

            for (int i = 0; i < 5; ++i) {
                int[] arr1 = map.get(s1.substring(i, i + 1));
                int[] arr2 = map.get(s2.substring(i, i + 1));

                for (int j = 0; j < 7; ++j) {
                    if (arr1[j] != arr2[j]) {
                        ++count;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();
    }
}
