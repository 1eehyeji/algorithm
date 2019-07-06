package baekjoon.collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B7785 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		Map<String, String> log = new HashMap<>();
		
		for(int i = 0; i < count; ++i) {
			String[] s = br.readLine().split(" ");
			log.put(s[0], s[1]);
		}
		
		List<String> list = new ArrayList<String>();
		
		for(String s : log.keySet()) {
			if(log.get(s).equals("enter"))
				list.add(s);
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		for(String s : list)
			System.out.println(s);
	}

}
