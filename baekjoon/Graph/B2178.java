package baekjoon.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
*/

public class B2178 {

    static int[] xp = { 0, 1, 0, -1 };
    static int[] yp = { 1, 0, -1, 0 };

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
        in.nextLine();

        int[][] a = new int[n][m];
        for(int i = 0; i < n; ++i){
            String s = in.nextLine();
            for(int j = 0; j < m; ++j){
                a[i][j] = s.charAt(j) - '0';
            }
        }

        boolean[][] check = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        int[][] distance = new int[n][m];

        check[0][0] = true;
        q.add(new Pair(0, 0));
        distance[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; ++k){
                int nextX = x + xp[k];
                int nextY = y + yp[k];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                    if(check[nextX][nextY] == false && a[nextX][nextY] == 1){
                        check[nextX][nextY] = true;
                        q.add(new Pair(nextX, nextY));
                        distance[nextX][nextY] = distance[x][y] + 1;
                    }
                }
            }
        }

        System.out.println(distance[n-1][m-1]);
        in.close();
	}

}
