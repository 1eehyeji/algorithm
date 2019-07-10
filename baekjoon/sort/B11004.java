package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 11004번 K번째 수 (https://www.acmicpc.net/problem/11004)
public class B11004 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list = list.stream().sorted().collect(Collectors.toList());

        System.out.println(list.get(k-1));
    }
}
