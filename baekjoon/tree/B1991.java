package baekjoon.tree;

import java.util.Scanner;

public class B1991 {

	static void preorder(int[][] a, int i) {
		if(i == -1) return;
		System.out.print((char)(i + 'A'));
		preorder(a, a[i][0]);
		preorder(a, a[i][1]);
	}
	static void inorder(int[][] a, int i) {
		if(i == -1) return;
		inorder(a, a[i][0]);
		System.out.print((char)(i + 'A'));
		inorder(a, a[i][1]);
	}
	static void postorder(int[][] a, int i) {
		if(i == -1) return;
		postorder(a, a[i][0]);
		postorder(a, a[i][1]);
		System.out.print((char)(i + 'A'));
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		int[][] a = new int[26][2];

		for (int i=0; i<n; i++) {
			String line = sc.nextLine();
			int x = line.charAt(0) - 'A';
			char y = line.charAt(2);
			char z = line.charAt(4);

			if (y == '.') {
				a[x][0] = -1;
			} else {
				a[x][0] = y-'A';
			}
			if (z == '.') {
				a[x][1] = -1;
			} else {
				a[x][1] = z-'A';
			}
		}

		preorder(a, 0);
		System.out.println();
		inorder(a, 0);
		System.out.println();
		postorder(a, 0);
		System.out.println();

	}

}
