package codility;

public class BinaryGap { 

	public static int solution(int n) {
		
		String binary = Integer.toBinaryString(n);
		System.out.println(binary);
		
		int max = 0;
		int count = 0;
		
		for(int i = 0; i < binary.length(); ++i) {
			if(binary.charAt(i) == '1') {
				if(max < count) {
					max = count;
				}
				count = 0;
			}
			if(binary.charAt(i) == '0') {
				++count;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(4)); //0
		System.out.println(solution(11240)); //1
		System.out.println(solution(529)); //4

	}

}
