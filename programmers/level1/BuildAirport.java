package programmers.level1;

public class BuildAirport {

	/* 경로 값을 직접 구해서 비교 후 최소 경로를 구하는 방법으로 구현함
	 * 프로그래머스 페이지에서 시간초과로 정답처리가 되지 않음
	 	public int chooseCity(int n, int [][]city) {
			if(n == 0) return n;
			int answer = city[0][0];
			long min = path(0, city);

			for(int i = 0; i < city.length; ++i) {
				long num = path(i, city);
				if(min > num) {
					min = num;
					answer = city[i][0];
				}
			}
			return answer;
		}	
	
		static long path(int i, int[][] city) {
			long num = 0;
			for(int j = 0; j < city.length; ++j) {
				if(i != j) {
					num += Math.abs(city[i][0] - city[j][0]) * city[j][1];
				}
			}
			return num;
		}
	 */
	
	/*
	 * 인구 수를 더하다가 총 인구 수의 절반이 되는 위치에 공항을 건설한다.
	 * 값은 잘 나오는 데 경로 값을 하나하나 비교하는 방법이 확실한 방법인 것 같음...
	 */
	public int chooseCity(int n, int [][]city) 
	{
		int answer = 0;
		
		long total = 0;
		
		for(int i = 0; i < city.length; ++i) {
			total += city[i][1];
		}
		
		long half = total / 2;
		total = 0;
		
		for(int i = 0; i < city.length; ++i) {
			total += city[i][1];
			if(total >= half) {
				answer = city[i][0];
				return answer;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args)
	{
		BuildAirport test = new BuildAirport();
		int tn = 3;	//도시 개수
		int [][]tcity = { {1, 5}, {2, 2}, {3, 3} };
		System.out.println(test.chooseCity(tn,tcity));
	}

}
