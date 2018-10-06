package baekjoon.Math;

import java.util.Scanner;

public class B11005 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int b = in.nextInt();

        StringBuilder builder = new StringBuilder();

        while(n > 0){
            int r = n % b;
            if(r < 10){
                builder.append(r);
            } else {
               builder.append((char)(r - 10 + 'A'));
            }
            n = n / b;
        }

        System.out.println(builder.reverse().toString());
    }
}
