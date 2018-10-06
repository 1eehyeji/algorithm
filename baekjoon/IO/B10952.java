package baekjoon.IO;

import java.util.Scanner;

public class B10952 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();

            if(a == 0 || b == 0) return;

            System.out.println(a+b);
        }

        in.close();
    }
}
