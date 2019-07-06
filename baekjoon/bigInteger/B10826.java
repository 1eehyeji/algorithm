package baekjoon.bigInteger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B10826 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger[] b = new BigInteger[Math.max(n+1, 2)];
		
		b[0] = BigInteger.ZERO;
		b[1] = BigInteger.ONE;
		
		for(int i = 2; i <= n; ++i) {
			b[i] = b[i-1].add(b[i-2]);
		}
		
		System.out.println(b[n]);
	}

}
