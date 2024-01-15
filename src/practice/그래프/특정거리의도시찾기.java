package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {

    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    private static int[] distance;

    private static int K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        distance = new int[N+1];
        A = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
        }

        findShortest(X);

        int cnt = 0;
        for (int i = 1; i < N+1; i++) {
            if (distance[i] == K) {
                System.out.println(i);
            } else {
                cnt++;
            }
        }

        if (cnt == N) {
            System.out.println(-1);
        }

    }

    private static void findShortest(int N) {
        Queue<Integer> queue = new LinkedList();
        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < A[n].size(); i++) {
                int temp = A[n].get(i);
                if (!visited[temp]) {
                    queue.add(temp);
                    visited[temp] = true;
                    distance[temp]  = distance[n] + 1;
                }
            }
        }
    }

}
