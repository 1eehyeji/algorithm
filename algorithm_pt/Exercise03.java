//제네릭 문법을 사용한 클래스 구현해보기
package algorithm_pt;

public class Exercise03<T> {

	private T[] arr;
	int count = 0;
	
	public Exercise03(int size) {
		this.arr = (T[]) new Object[size];
	}
	
	public void put(T value) {
		this.arr[count] = value;
		++count;
	}
	
	public T get(int index) {
		return arr[index];
	}
	
	public static void main(String[] args) {
		Exercise03<Integer> a = new Exercise03<Integer>(10);
		a.put(0);
		a.put(1);
		Integer a1 = a.get(0);
		Integer a2 = a.get(1);
		System.out.println(a1 + " " + a2);
		
		Exercise03<String> s = new Exercise03<String>(10);
		s.put("hello");
		s.put("world");
		String s1 = s.get(0);
		String s2 = s.get(1);
		System.out.println(s1 + " " + s2);
	}
}
