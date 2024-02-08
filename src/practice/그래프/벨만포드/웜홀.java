package practice.그래프.벨만포드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 웜홀 {

    private static int[] distance;

    private static ArrayList<Edge> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int a = 0; a < TC; a++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            distance = new int[N+1];

            edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken()) * -1;
                edges.add(new Edge(S, E, T));
            }

            boolean isMinusCycle = false;

            for (int i = 1; i < N+1; i++) {
                for (Edge edge : edges) {
                    if (distance[edge.end] > distance[edge.start] + edge.time) {
                        distance[edge.end] = distance[edge.start] + edge.time;

                        if(i == N) {
                            isMinusCycle = true;
                        }
                    }
                }
            }

            if (isMinusCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
class Edge{
    int start;
    int end;
    int time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
