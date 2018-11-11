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
		
		long max = 2000000000L * 30; // L�� �Ⱦ��� �ȵ��ư�,, ��
		long min = 0;
		
		while(min <= max) {
			long mid = (min + max) / 2;			
			long end, begin = 0;
			
			end = m;
			for(int i = 0; i < m; ++i) {	// mid�б��� ź ��� ��
				end += mid/a[i];
			}
			begin = end;
			for(int i = 0; i < m; ++i) {
				if(mid % a[i] == 0) {
					--begin;
				}
			}
			++begin;		// mid�п� ź ����� �� ù ��° ��������� ��
			
			if(n < begin) {
				max = mid - 1;
			} else if(n > end) {
				min = mid + 1;
			} else {
				for(int i = 0; i < m; ++i) {
					if(mid % a[i] == 0) {	// �� ��° �ⱸ�� ������ ã��
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
