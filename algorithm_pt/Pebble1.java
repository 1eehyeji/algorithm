package algorithm_pt;

public class Pebble1 {
	static int[][] pb = {
			{ 6, 7, 12, -5, 5, 3, 11, 3 },
			{ -8, 10, 14, 9, 7, 13, 8, 5 },
			{ 11, 12, 7, 4, 8, -2, 9, 4 } };
	
	static int[][] a = new int[8][5]; // 동적 프로그래밍을 위한 배열
	
	static boolean available(int p1, int p2) {
		if(p1 == p2) return false;
		int[][] p = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; //인접 가능하지 않은 패턴
		for(int i = 0; i < p.length; ++i) {
			if(p[i][0] == p1 && p[i][1] == p2) return false;
		}
		return true;
	}
	
	static int colPoint(int c , int p) throws Exception{
		switch(p) {
		case 1: return pb[0][c];
		case 2: return pb[1][c];
		case 3: return pb[2][c];
		case 4: return pb[0][c] + pb[2][c];
		}
		
		throw new Exception("잘못된 패턴 입력입니다. " + p);
	}
	
	static int count = 0;
	
	static int maxPoint(int c, int p) throws Exception{
		if(a[c][p] != 0) return a[c][p];
		
		++count;
		if(c == 0) return a[c][p] = colPoint(c, p);
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= 4; ++i) {
			if(available(p, i)) {
				int point = maxPoint(c-1, i);			
				if(point > max) max = point;
			}
		}
		return a[c][p] = max + colPoint(c, p);
	}
	
	static int maxPoint(int c) throws Exception{
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= 4; ++i) {
			int point = maxPoint(c , i);
			if(point > max) max = point;
		}
		return max;
	}
	
	static boolean print(int c, int point) throws Exception{
		String[] s = {"", "*", "  *", "   *", "*   *"};
		for(int p = 1; p <= 4; ++p) {
			if(a[c][p] == point && (c == 0  || print(c - 1, point - colPoint(c, p)))) {
				System.out.printf("열:%d 패턴:%d 조약돌:%s\n", c, p, s[p]);
				return true;
			}
		}
		return false;
	}
	
	static void print() {
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a[i].length; ++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(maxPoint(7));
		System.out.println(count);
		
		print();
		print(7, maxPoint(7));
	}

}
