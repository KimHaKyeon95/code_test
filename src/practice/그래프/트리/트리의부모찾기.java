package practice.그래프.트리;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    private static ArrayList<Integer>[] edges;
    private static boolean[] visited;

    private static int[] parents;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            edges[a].add(b);
            edges[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int i : edges[node]) {
                if (!visited[i]) {
                    queue.add(i);
                    parents[i] = node;
                }
            }
        }
        for (int i = 2; i < N+1; i++) {
            System.out.println(parents[i]);
        }
    }
}
