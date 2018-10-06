package baekjoon.Collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B10815 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] s1 = br.readLine().split(" ");
		//List<Integer> list = new ArrayList<>();
		Set<Integer> card = new HashSet<>();
		
		for(String s : s1) {
			card.add(Integer.parseInt(s));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		String[] s2 = br.readLine().split(" ");
		
		for(int i = 0; i < m; ++i) {
			if(card.contains(Integer.parseInt(s2[i])))
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		
		/* Hash Set을 활용하여 문제를 빠르게 해결할 수 있음 */
	}

}
