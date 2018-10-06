package baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class B1158 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        in.close();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; ++i){
            q.offer(i+1);
        }

        StringJoiner joiner = new StringJoiner(", ");

        while(!q.isEmpty()){
            for(int j = 0; j < m - 1; ++j){
                q.offer(q.poll());
            }
            joiner.add(q.poll().toString());
        }

        System.out.println("<" + joiner + ">");
    }
}
