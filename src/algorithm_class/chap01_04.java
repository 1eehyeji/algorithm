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
			Node root = new Node(this.value, this.next);

			while(root != null) {
				System.out.print(root.value + " ");
				root = root.next;
			}
		}

		public void addTail(int value) {
			Node root = new Node(this.value, this.next);

			while(root != null) {
				root = root.next;
			}

			Node nn = new Node(value, null);
			root = nn;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(0, null);

		for(int i=0; i<=10; ++i)
			root.addTail(i);

		root.printAll();
	}

}
