package baekjoon.bigInteger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class B10827 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		BigDecimal a = new BigDecimal(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		BigDecimal result = a.pow(n);
		System.out.println(result.toPlainString());
	}

}
