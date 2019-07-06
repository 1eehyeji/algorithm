package baekjoon.iO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2739 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; ++i)
            System.out.printf("%d * %d = %d\n", n, i, n*i);

        br.close();
    }
}
