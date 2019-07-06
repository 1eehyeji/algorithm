package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class B7576 {
    static int[] xp = { 0, 1, 0, -1 };
    static int[] yp = { 1, 0, -1, 0 };

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] a = new int[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                a[i][j] = in.nextInt();
                distance[i][j] = -1;
                if(a[i][j] == 1){
                    distance[i][j] = 0;
                    ((LinkedList<Pair>) q).add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; ++i){
                int nextX = x + xp[i];
                int nextY = y + yp[i];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                    if(a[nextX][nextY] == 0 && distance[nextX][nextY] == -1){
                        ((LinkedList<Pair>) q).add(new Pair(nextX, nextY));
                        distance[nextX][nextY] = distance[x][y] + 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; ++i){     // 모든 토마토가 익는데 걸리는 시간
            for(int j = 0; j < m; ++j){
                if(max < distance[i][j])
                    max = distance[i][j];
            }
        }

        for(int i = 0; i < n; ++i){     // 모든 토마토가 다 익지 못하는 경우
            for(int j = 0; j < m; ++j){
                if(a[i][j] == 0 && distance[i][j] == -1)
                    max = -1;
            }
        }

        System.out.println(max);
        in.close();
    }
}
