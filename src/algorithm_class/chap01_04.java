// 리스트 끝에 Node가 추가 되지 않음
package algorithm_class;

public class chap01_04 {

	static class Node{
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void printAll() {
			System.out.printf("%d ", this.value); 
			if (next != null) next.printAll();
		}

		public void addTail(int value) {
			if(next != null) next.addTail(value);
			else {
				next = new Node(value, null);
			}
		}
	}

	public static void main(String[] args) {

		Node root = new Node(0, null);

		for(int i=1; i<=10; ++i)
			root.addTail(i);

		root.printAll();
	}

}
