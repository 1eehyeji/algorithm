package algorithm_pt;

import java.util.Random;

import algorithm_pt.Excercise02_BST.Node;

//이진트리 contatins 구현
public class Excercise02_main {

	public static void main(String[] args) {

		Random r = new Random();
		Node root = new Node(r.nextInt(20));
		
		for(int i = 0; i<15; ++i)
			root.add(r.nextInt(20));
		
		root.print();
		System.out.println();
		
		System.out.println("반복문 contatins");
		
		for (int i = 0; i< 20; ++i) {
			int value = r.nextInt(20);
			System.out.printf("%d %s\n", value, root.contains(value));
		}
		
		System.out.println("재귀함수 contatins");
		
		for (int i = 0; i< 20; ++i) {
			int value = r.nextInt(20);
			System.out.printf("%d %s\n", value, root.contains(root, value));
		}
	}
}
