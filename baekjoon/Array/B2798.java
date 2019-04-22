package baekjoon.Array;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2798 {

	static int solution(int n, int m, int[] arr) {

		List<Integer> list = new ArrayList<Integer>();

		for(int i : arr) list.add(i);
		list.add(m);
		
		Collections.sort(list);

		int size = list.indexOf(m); // m보다 값이 큰 카드는 제외
		int max = 0;
		
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				for(int k = 0; k < size; ++k) {
					if(i != j && j != k && k != i) {
						int sum = list.get(i) + list.get(j) + list.get(k);
						if(sum == m) return sum;
						else if(sum < m && sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] arr = new int[s.length];
		for(int i = 0; i < s.length; ++i) 
			arr[i] = Integer.parseInt(s[i]);

		System.out.println(solution(n, m, arr));
	}

}
