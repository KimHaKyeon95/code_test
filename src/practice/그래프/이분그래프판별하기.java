package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프판별하기{
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int[] set;
    private static boolean isEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V+1];
            for (int j = 1; j < V+1; j++) {
                A[j] = new ArrayList<>();
            }

            visited = new boolean[V+1];
            set = new int[V+1];
            isEven = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                A[a].add(b);
                A[b].add(a);
            }

            for (int j = 1; j < V+1; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if(!visited[i]) {
                set[i] = (set[node] + 1) % 2;
                dfs(i);
            } else if (set[node] == set[i]) {
                isEven = false;
            }
        }
    }
}