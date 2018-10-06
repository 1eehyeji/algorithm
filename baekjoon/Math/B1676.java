package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B1676 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger result = BigInteger.ONE;
        for(int i = n; i > 0; --i){
            result = result.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while(result.mod(BigInteger.valueOf(10)).intValue() == 0){
            count += 1;
            result = result.divide(BigInteger.valueOf(10));
        }

        System.out.println(count);
    }
}
