package algorithm_pt;

public class Exercise02_BST{

	static class Node{
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		public boolean contains(Node root, int value) {
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

		public void add(int value) {
			if (value<this.value) {
				if (leftChild == null) leftChild = new Node(value);
				else leftChild.add(value);
			}else if(value > this.value) {
				if(rightChild == null) rightChild = new Node(value);
				else rightChild.add(value);
			}
		}

		public boolean contains(int value) {
			Node p = this;
			
			while(p != null) {
				if(p.value == value) return true;
				else if(p.value > value)
					p = p.leftChild;
				else
					p = p.rightChild;
			}
			return false;
		}
		
		public void print() {
			if(leftChild != null) leftChild.print();
				System.out.printf("%d ", value);
			if(rightChild != null) rightChild.print();
		}
	}

}
