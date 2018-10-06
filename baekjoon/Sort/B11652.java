package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B11652 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        long maxNum = Long.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i < n ; ++i){
            long m = Long.parseLong(br.readLine());
            if(map.get(m) == null){
                count = 1;
            }
            else{
                count = map.get(m) + 1;
            }
            map.put(m, count);

            if(count > max || (count == max && m < maxNum)){
                max = count;
                maxNum = m;
            }
        }
        System.out.println(maxNum);
    }
}
