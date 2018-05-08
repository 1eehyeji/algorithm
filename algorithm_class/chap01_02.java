package algorithm_class;

public class chap01_02 {

	static int sum(int n) {
		if(n == 1) return n;
		return n + sum(n-1);
	}

	public static void main(String[] args) {
		for(int i = 3; i <= 10; ++i)
			System.out.println( i + " " + sum(i));
	}
}
