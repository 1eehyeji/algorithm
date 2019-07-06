package baekjoon.iO;

import java.util.Scanner;

public class B11720 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        in.nextLine();

        String[] s = in.nextLine().split("");
        int sum = 0;

        for(int i = 0; i < size; ++i){
            sum += Integer.parseInt(s[i]);
        }

        System.out.println(sum);
    }
}
