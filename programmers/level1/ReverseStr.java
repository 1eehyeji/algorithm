package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 조금 더 간단하게 구현하는 방법이 있을 것 같음
 * StringBuilder or StringBuffer을 활용해서 해결 가능할 것 같음
 * List, ArrayList, Arrays, Collections 관련해서 공부가 더 필요한 것 같음
 */
public class ReverseStr {
	public String reverseStr(String str){
		List<Character> list = new ArrayList<Character>();
		for(int i = 0; i < str.length(); ++i) {
			list.add(str.charAt(i));
		}
		Collections.sort(list);
		Collections.reverse(list);
		String s = "";
		for(char c : list) {
			s += c;
		}
		return s;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("Zbcdefg") );
	}
}