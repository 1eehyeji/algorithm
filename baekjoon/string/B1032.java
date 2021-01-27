package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 명령 프롬프트
public class B1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] commands = new String[N];
        for (int i = 0; i < N; ++i) {
            commands[i] = br.readLine();
        }

        char[] pattern = commands[0].toCharArray();
        for (int i = 1; i < commands.length; ++i) {
            String command = commands[i];
            for (int j = 0; j < pattern.length; ++j) {
                if (command.charAt(j) != pattern[j])
                    pattern[j] = '?';
            }
        }

        System.out.println(pattern);
    }
}
