package baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1561 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] a = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if (n <= m) {
            System.out.println(n);
            return;
        }
		
		long max = 2000000000L * 30; // L을 안쓰면 안돌아감,, ㅜ
		long min = 0;
		
		while(min <= max) {
			long mid = (min + max) / 2;			
			long end, begin = 0;
			
			end = m;
			for(int i = 0; i < m; ++i) {	// mid분까지 탄 사람 수
				end += mid/a[i];
			}
			begin = end;
			for(int i = 0; i < m; ++i) {
				if(mid % a[i] == 0) {
					--begin;
				}
			}
			++begin;		// mid분에 탄 사람들 중 첫 번째 사람까지의 수
			
			if(n < begin) {
				max = mid - 1;
			} else if(n > end) {
				min = mid + 1;
			} else {
				for(int i = 0; i < m; ++i) {
					if(mid % a[i] == 0) {	// 몇 번째 기구에 탔는지 찾음
						if(begin == n) {
							System.out.println(i + 1);
							return;
						}
						++begin;
					}
				}
			}
		}
	}

}
