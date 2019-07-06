package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 수 정렬하기3
// Sort로 풀면 안됨, Scanner 사용하면 안됨
public class B10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001]; // 주어지는 숫자는 10000보다 작거나 같음

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(Integer.toString(i) + "\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
