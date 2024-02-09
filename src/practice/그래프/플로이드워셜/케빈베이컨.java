package practice.그래프.플로이드워셜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨 {

    private static int[][] kevin;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        kevin = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i == j) {
                    kevin[i][j] = 0;
                } else {
                    kevin[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            kevin[A][B] = 1;
            kevin[B][A] = 1;
        }

        for (int k = 1; k < N+1; k++) {
            for (int s = 1; s < N+1; s++) {
                for (int e = 1; e < N+1; e++) {
                    if (kevin[s][k] != Integer.MAX_VALUE && kevin[k][e] != Integer.MAX_VALUE && s != e) {
                        kevin[s][e] = Math.min(kevin[s][e], kevin[s][k] + kevin[k][e]);
                    }
                }
            }
        }

        int minimum = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 1; i < N+1; i++) {
            int temp = 0;
            for (int j = 1; j < N+1; j++) {
                temp += kevin[i][j];
            }
            if (minimum > temp) {
                minimum = temp;
                result = i;
            }
        }

        System.out.println(result);
    }

}
