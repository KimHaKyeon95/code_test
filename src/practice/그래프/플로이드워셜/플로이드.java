package practice.그래프.플로이드워셜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {

    private static int[][] distance;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        distance = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if (distance[start][end] > time) {
                distance[start][end] = time;
            }
        }

        for (int k = 1; k < N+1; k++) {
            for (int s = 1; s < N+1; s++) {
                for (int e = 1; e < N+1; e++) {
                    if (distance[s][k] != Integer.MAX_VALUE && distance[k][e] != Integer.MAX_VALUE && s != e) {
                        distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
                    }
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
