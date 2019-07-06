package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2263 {

	static int[] inorder;
	static int[] postorder;
	static int n;

	static int find_index(int value) {
		int i = 0;
		for(; i < n; ++i) {
			if(inorder[i] == value)
				break;
		}
		return i;
	}

	static void preorder(int in_st, int post_st, int len) {
		if(len <= 0)
			return;
		if(len == 1) {
			System.out.print(postorder[post_st] + " ");
			return;
		}
		System.out.print(postorder[post_st + len - 1] + " ");
		int in_root_idx = find_index(postorder[post_st + len - 1]);
		int left_len = in_root_idx - in_st;
		preorder(in_st, post_st, left_len);
		int right_len = len - left_len - 1;
		preorder(in_root_idx + 1, post_st + left_len, right_len);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		inorder = new int[n];
		for(int i = 0; i < n; ++i) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		postorder = new int[n+1];
		for(int i = 0; i < n; ++i) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		preorder(0, 0, n);

		System.out.println();
	}

}
