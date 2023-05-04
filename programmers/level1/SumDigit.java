package programmers.level1;

public class SumDigit {

	static int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for(int i = 0; i < s.length(); ++i) {
        	answer += (s.charAt(i) - '0'); //char형을 int로 바꾸어주기 위해서 '0'(=48)을 빼줌
        }
        return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 123;
		int num2 = 987;
		
		System.out.println(solution(num1));
		System.out.println(solution(num2));
	}

}
