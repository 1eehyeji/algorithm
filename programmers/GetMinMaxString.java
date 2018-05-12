package programmers;

/*
 * getMinMaxString 메소드는 String형 변수 str을 매개변수로 입력받습니다.
 * str에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아
 * (최소값) (최대값)형태의 String을 반환하는 메소드를 완성하세요.
 */

public class GetMinMaxString {
    public String getMinMaxString(String str) {
    	String[] s = str.split(" ");
    	int[] arr = new int[s.length];
    	
    	for(int i = 0; i < s.length; i++) {
    	    arr[i] = Integer.parseInt(s[i]);
    	}
    	
    	int min = arr[0];
    	int max = arr[0];
    	for(int i = 1; i < s.length; ++i) {
    		if(min > arr[i]) min = arr[i];
    		if(max < arr[i]) max = arr[i];
    	}
        return min + " " + max;
    }

    public static void main(String[] args) {
        String str = "1 2 0 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은? " + minMax.getMinMaxString(str));
    }
}