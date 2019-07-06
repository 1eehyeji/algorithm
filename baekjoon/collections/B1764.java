package baekjoon.collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1764 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			map.put(br.readLine(), 0);
		}
		
		for(int i = 0; i < m; ++i) {
			String key = br.readLine();
			if(map.containsKey(key)) map.put(key, 1);
		}

		List<String> list = new ArrayList<String>();
		for(String str : map.keySet()) {
			if(map.get(str) == 1) list.add(str);
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String str : list)
			System.out.println(str);
	}

}
