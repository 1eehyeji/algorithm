package algorithm_pt;

public class bubbleSort_String {

	static void swap(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	static void bubbleSort(String[] s) {
		boolean already = true;
		
		for(int i = s.length - 1; i > 0; --i) {
			for(int j = 0; j < i; ++j) {
				if(s[j].compareTo(s[j + 1]) > 0) {
					swap(s, j, j + 1);
					already = false;
				}
			}
			if(already) break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = { "d", "a", "b", "e", "c" };
		
		bubbleSort(s);
		
		for(String str : s) {
			System.out.printf("%s ", str);
		}
	}

}
