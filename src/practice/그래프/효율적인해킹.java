package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {

    private static int N;
    private static int M;
    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    private static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
        }

        answer = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int maxVal = 0;
        for (int i = 1; i < N+1; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }

        for (int i = 1; i < N+1; i++) {
            if (answer[i] == maxVal) {
                System.out.print(i + " ");
            }
        }

    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (int i : A[a]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    answer[i]++;
                }
            }
        }
    }
}
