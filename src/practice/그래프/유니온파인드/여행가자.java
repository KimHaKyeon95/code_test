package practice.그래프.유니온파인드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
    private static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());


        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        int[][] city = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());;
            }
        }

        int[] route = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < M+1; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int result = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (result != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        int n = find(a);
        int m = find(b);

        if (n != m) {
            parent[m] = n;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

}
