package algorithm_pt;

//binary tree add 재귀함수, 반복문 구현

public class Exercise01 {

	public static class Node{
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public static class BST{
		Node root;

		public void add(int value) {
			if(root == null) {
				Node nn = new Node(value);
				root = nn;
			}else {
				add(value, root);
			}
		}
		public void add(int value, Node root) {

			if(root.value > value) {

				if(root.leftChild == null) {
					Node nn = new Node(value);
					root.leftChild = nn;
				}else {
					add(value, root.leftChild);
				}

			}else if(root.value < value){

				if(root.rightChild == null) {
					Node nn = new Node(value);
					root.rightChild = nn;
				}else {
					add(value, root.rightChild);
				}

			}else {

				System.out.println("이미 존재하는 값입니다.");

			}
		}

		public void printAll() {
			if(root == null) {
				System.out.println("트리에 존재하는 값이 없습니다.");
			}else {
				printAll(root);
			}
		}

		public void printAll(Node root) {
			System.out.println(root.value + " ");
			if(root.leftChild != null)
				printAll(root.leftChild);
			if(root.rightChild != null)
				printAll(root.rightChild);

		}
	}

	public static void main(String[] args) {

		BST root = new BST();

		root.add(3);
		root.add(1);
		root.add(4);

		root.printAll();
	}

}
