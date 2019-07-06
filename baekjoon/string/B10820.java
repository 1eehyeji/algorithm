package baekjoon.string;

import java.util.Scanner;

public class B10820 {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String s = in.nextLine();
            int apb = 0;
            int APB = 0;
            int num = 0;
            int space = 0;

            for(int i = 0; i< s.length(); ++i){
                char c = s.charAt(i);
                if(c == 32) space += 1;
                else if(47 < c && c < 58) num += 1;
                else if(64 < c && c < 91) APB += 1;
                else if(96 < c && c < 123) apb += 1;
            }

            System.out.println(apb + " " + APB + " " + num + " " + space);
        }

        in.close();
    }
}
