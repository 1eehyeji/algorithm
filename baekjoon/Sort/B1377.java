package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B1377 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> sorted = new HashMap<>();

        int[] a = new int[n];

        for (int i = 0; i < n; ++i) {
            int m = Integer.parseInt(br.readLine());
            map.put(i+1, m);    // key : index, value : value
            a[i] = m;
        }

        Arrays.sort(a);
        for (int i = 0; i < n ; ++i)
            sorted.put(a[i], i+1);  // key : value, value : index

        int max = 0;
        for (int i = 1; i <= n; ++i) {
            int key = map.get(i);
            if (i > sorted.get(key))
                if (max <  i - sorted.get(key))
                    max = i - sorted.get(key);
        }

        System.out.println(max + 1);
    }
}
