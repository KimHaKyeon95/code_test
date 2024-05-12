package practice.탐색.dfs.백준11724;

import java.io.*;
import java.util.*;

public class 백준11724 {
    public static ArrayList<Integer>[] A;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        int count = 0;
        for(int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int n) {
        if (visited[n]) {
            return;
        }
        visited[n] = true;
        for (int i : A[n]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
