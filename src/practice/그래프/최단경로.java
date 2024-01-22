package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

    private static int V;
    private static int E;
    private static int K;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<Edge>[] list;
    private static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<Edge>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int c_v = current.vertex;
            if (visited[c_v]) {
                continue;
            }
            visited[c_v] = true;
            for (int i = 0; i < list[c_v].size(); i++) {
                Edge temp = list[c_v].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if (distance[next] > distance[c_v] + value) {
                    distance[next] = value + distance[c_v];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i < V+1; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }


}
class Edge implements Comparable<Edge> {
    int vertex;
    int value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e) {
        if (this.value > e.value) {
            return 1;
        } else {
            return -1;
        }
    }
}
