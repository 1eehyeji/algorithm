package programmers;

public class MiddleChar {

	public static String solution(String s) {
	      String answer = "";
	      
	      if(s.length() == 0) return answer; //길이가 0일때 빈문자열 반환
	      
	      int middle = s.length() / 2;
	      
	      if((s.length() % 2) != 0) {
	    	  answer = s.substring(middle, middle+1);
	      } else {
	    	  answer = s.substring(middle-1, middle+1);
	      }

	      //answer = (s.length() % 2 ) != 0 ? s.substring(middle, middle + 1) : s.substring(middle - 1, middle + 1);
	      
	      return answer;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcde";
		String s2 = "qwer";
		
		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

}
