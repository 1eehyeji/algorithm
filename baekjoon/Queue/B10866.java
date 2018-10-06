package baekjoon.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<String> dq = new LinkedList<>();

        for(int i = 0; i < n; ++i){
            String[] s = br.readLine().split(" ");

            switch (s[0]){
                case "push_back":
                    dq.addLast(s[1]);
                    break;
                case "push_front":
                    dq.addFirst(s[1]);
                    break;
                case "pop_front":
                    if(dq.isEmpty()) System.out.println("-1");
                    else System.out.println(dq.pollFirst());
                    break;
                case "pop_back":
                    if(dq.isEmpty()) System.out.println("-1");
                    else System.out.println(dq.pollLast());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if(dq.isEmpty()) System.out.println("-1");
                    else System.out.println(dq.peekFirst());
                    break;
                case "back":
                    if(dq.isEmpty()) System.out.println("-1");
                    else System.out.println(dq.peekLast());
                    break;
            }
        }

        br.close();
    }
}
