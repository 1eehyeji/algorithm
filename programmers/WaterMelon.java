package programmers;

public class WaterMelon {
	public String watermelon(int n){
		/*String s = "";
		
		for(int i = 0; i < n; ++i){
			if(i % 2 == 0) s += "수";
			else s += "박";
		}*/

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < (n / 2); ++i) {
			sb.append("수박");
		}

		if ((n % 2) > 0) {
			sb.append("수");
		}

		return sb.toString();
	}

	public static void  main(String[] args){
	}
}
