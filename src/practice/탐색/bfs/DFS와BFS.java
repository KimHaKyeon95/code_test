package practice.탐색.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < N+1; i++) {
            Collections.sort(A[i]);
        }

        dfs(V);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }

    private static void dfs(int now) {
        if (visited[now]) {
            return;
        }
        visited[now] = true;
        System.out.print(now + " ");
        for (int i : A[now]) {
            dfs(i);
        }
    }

    private static void bfs(int now) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(now);
        visited[now] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i : A[node]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
