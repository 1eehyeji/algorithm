package programmers.level2;

import java.util.Arrays;

public class 전화번호목록 {

	public static boolean solution(String[] phone_book) {
		Trie trie = new Trie();

		Arrays.sort(phone_book, (a, b) -> (b.length() - a.length()));

		for (String s : phone_book) {
			if (trie.search(s)) {
				return false;
			}

			trie.insert(s);
		}

		return true;
	}

	public static void main(String[] args) {

	}
}

class Trie {

	Node root;

	public Trie() {
		this.root = new Node("");
	}

	public void insert(String s) {
		Node temp = root;

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			int index = c -'0';

			if (temp.getChild(index) == null) {
				Node node = new Node(String.valueOf(c));
				temp.setChild(index, node);
				temp = node;
			} else {
				temp = temp.getChild(index);
			}
		}

		temp.isLeap = true;
	}

	public boolean search(String s) {
		Node temp = root;

		for (int i = 0; i < s.length(); ++i) {
			int index = s.charAt(i) - '0';

			if (temp.getChild(index) == null) {
				return false;
			} else {
				temp = temp.getChild(index);
			}
		}

		return true;
	}

}

class Node {

	String number;
	Node[] child;
	boolean isLeap;

	public Node(String s) {
		this.number = s;
		this.child = new Node[10];
	}

	public Node getChild(int index) {
		return child[index];
	}

	public void setChild(int index, Node node) {
		this.child[index] = node;
	}

}
