package baekjoon.IO;

import java.util.Scanner;

public class B10951 {
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();
            System.out.println(a+b);
        }

        in.close();
    }
}
