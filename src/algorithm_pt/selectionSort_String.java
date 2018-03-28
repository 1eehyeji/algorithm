package algorithm_pt;

public class selectionSort_String {

	static void selectionSort(Comparable[] s) {
		for(int i = 0; i < s.length; ++i) {
			int minIdx = findMin(s, i);
			swap(s, i, minIdx);
		}
	}

	static int findMin(Comparable[] s, int start) {
		int min = start;
		for(int i = start + 1; i < s.length; ++i) {
			if(s[min].compareTo(s[i]) > 0) {
				min = i;
			}
		}
		return min;
	}
	
	static void swap(Comparable[] s, int i, int j) {
		Comparable temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] s = { "abc", "aaa", "adb", "aff", "aee" };
		
		selectionSort(s);
		
		for(String str : s) {
			System.out.printf("%s ", str);
		}
	}

}
