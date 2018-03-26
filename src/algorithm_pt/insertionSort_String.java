package algorithm_pt;

public class insertionSort_String {

	static void insertionSort(String[] s) {
		
		for(int i = 1; i < s.length; ++i) {
			
			String value = s[i];
			int j;
			
			for(j = i - 1; j >= 0; --j) {
				
				if(s[j].compareTo(value) > 0) {
					s[j + 1] = s[j];
				}
				else break;
				
			}
			
			s[j + 1] = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = { "d", "a", "b", "e", "c" };
		
		insertionSort(s);
		
		for(String str : s) {
			System.out.printf("%s ", str);
		}
	}

}
