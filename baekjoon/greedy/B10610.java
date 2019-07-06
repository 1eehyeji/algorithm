package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 30
public class B10610 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
           list.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
		Collections.sort(list);

		int sum = 0;
		for(int j : list)
			sum += j;

		if(list.get(0) == 0 && (sum % 3) == 0) { // 0이 하나라도 존재하고, 숫자를 다 더한 값이 3의 배수일때
			Collections.reverse(list);
			for(int j : list)
				System.out.print(j);		// 가장 큰수를 만듬
		}
		else
			System.out.println(-1);
	}

}
