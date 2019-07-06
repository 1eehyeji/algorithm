package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼각형 닮음을 이용해서 해결,,
public class B2022 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		double min = 0;
		double max = Math.min(x, y);
		
		for(int i = 0; i < 10000; ++i) { // 값이 소수일 수 있기 때문에 min <= max로 표현할 수 없음
			double mid = (min + max) / 2.0;
			double h1 = Math.sqrt((x * x) - (mid * mid));
			double h2 = Math.sqrt((y * y) - (mid * mid));
			double h = (h1 * h2) / (h1 + h2);
			
			if(h > c) {
				min = mid;
			} else {
				max = mid;
			}
		}
		System.out.printf("%.3f", min);
	}

}
