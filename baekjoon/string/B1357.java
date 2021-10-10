package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒤집힌 덧셈
public class B1357 {

    public static int rev(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int X = Integer.parseInt(arr[0]);
        int Y = Integer.parseInt(arr[1]);

        System.out.println(rev(rev(X) + rev(Y)));
    }
}
