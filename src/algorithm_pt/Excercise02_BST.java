package algorithm_pt;

public class Excercise02_BST{
	Node root;

	public static boolean contains(Node root, int value) {
		if(root == null)
			return false;
		if(root.value == value) {
			return true;
		}else if(root.value > value) {
			return contains(root.leftChild, value);
		}else {
			return contains(root.rightChild, value);
		}
	}

	public static void add(Node root, int value) {
		if(root == null) {
			Node nn = new Node(value);
			root = nn;
		} else {

			if(root.value > value) {
				add(root.leftChild, value);
			}else if(root.value < value) {
				add(root.rightChild, value);
			}else {
				System.out.println("이미 존재하는 값입니다.");
			}

		}
	}

	public boolean contains(int value) {
		while(this != null) {

		}
		return true;
	}

	static class Node{
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

}
