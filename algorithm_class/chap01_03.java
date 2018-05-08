package algorithm_class;

public class chap01_03 {

	static class Node{
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void printAll() {
			Node nn = new Node(this.value, this.next);

			while(nn != null) {
				System.out.print(nn.value + " ");
				nn = nn.next;
			}
		}

		public void printAll(Node root) {
			if(root.next != null) {
				printAll(root.next);
			}

			System.out.printf("%d ", root.value);
		}
	}

	public static void main(String[] args) {

		Node root = null;

		for(int i = 1; i <= 10; ++i)
			root = new Node(i, root);

		root.printAll();
		System.out.println();

		root.printAll(root);
	}

}
