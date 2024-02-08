package practice.그래프.벨만포드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타임머신 {

    private static long[] distance;
    private static CityEdge[] edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new long[N+1];
        edges = new CityEdge[M+1];


        for (int i = 1; i < N+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges[i] = new CityEdge(start, end, time);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                CityEdge cityEdge = edges[j];
                if (distance[cityEdge.start] != Integer.MAX_VALUE) {
                    distance[cityEdge.end] = Math.min(distance[cityEdge.end], cityEdge.time + distance[cityEdge.start]);
                }
            }
        }

        boolean isMinusCycle = false;
        for (int i = 0; i < M; i++) {
            CityEdge cityEdge = edges[i];
            if (distance[cityEdge.start] != Integer.MAX_VALUE && distance[cityEdge.end] > cityEdge.time + distance[cityEdge.start]) {
                isMinusCycle = true;
                break;
            }
        }

        if (!isMinusCycle) {
            for (int i = 2; i < N+1; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println(-1);
        }

    }

}

class CityEdge {
    int start;
    int end;
    int time;

    public CityEdge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}