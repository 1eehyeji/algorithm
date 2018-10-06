package baekjoon.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2751 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; ++i)
            list.add(in.nextInt());

        Collections.sort(list);

        for(int i : list)
            System.out.println(i);

    }
}
