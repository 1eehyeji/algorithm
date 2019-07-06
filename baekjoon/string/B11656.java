package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B11656 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        br.close();

        List<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); ++i){
            list.add(s.substring(i));
        }

        Collections.sort(list);

        for(String str : list)
            System.out.println(str);
    }
}
