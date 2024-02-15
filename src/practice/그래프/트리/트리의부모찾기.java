package practice.그래프.트리;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    private static ArrayList<Integer>[] edges;
    private static boolean[] visited;

    private static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        dfs(1);
        for (int i = 2; i < N+1; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int a) {
        if (visited[a]) {
            return;
        }
        visited[a] = true;
        for (int i : edges[a]) {
            if (!visited[i]) {
                parents[i] = a;
                dfs(i);
            }
        }
    }
}
