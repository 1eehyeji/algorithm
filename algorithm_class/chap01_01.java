package algorithm_class;

public class chap01_01 {

	static int sum(int[] a, int index) {
		//index가 배열의 마지막 index값이 되면 재귀함수가 종료된다.
		if(index >= a.length-1) return a[index];
		//현재 index에 해당하는 값과 index+1에 해당하는 값을 더하여 return한다.
		return a[index] + sum(a, index + 1);

	}

	public static void main(String[] args) {

		int[] a = {10, 10, 10, 10};

		System.out.println(sum(a, 0));
	}
}
