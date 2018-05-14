package codility;

import java.util.HashMap;

public class OddOccurrencesInArray {

	static int solution(int a[]) {
		int oddOccurrence = -999; //배열에 값이 모두 짝을 이룰경우에 -999를 반환
		
		if(a.length == 0) return oddOccurrence;
		if(a.length == 1) return a[0];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < a.length; ++i) {
			Integer count = map.get(a[i]); 
			// count가 Integer형인 이유 : 처음으로 키값을 넣어줬을 때 count 값으로 1을 넣어주기위해서
			if(count == null) map.put(a[i], 1);
			else map.put(a[i], count + 1);			
		}

		for(int i = 0; i < a.length; ++i) {
			if(map.get(a[i]) % 2 != 0)
				oddOccurrence = a[i];
		}
		
		return oddOccurrence;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 9, 3, 9, 3, 9, 7, 9 };
		System.out.println(solution(a));
		
		int[] b = { 2, 2 };
		System.out.println(solution(b));
	}

}
