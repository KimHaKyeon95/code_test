package practice.그래프.백준1504;


import java.io.*;
import java.util.*;

public class 백준1504 {
    private static ArrayList<Node>[] A;
    private static int[] distance;
    private static boolean[] visited;
    private static int v1;
    private static int v2;

    private static int N;
    private static int E;
    private static final int INF = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, c));
            A[b].add(new Node(a, c));
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int route1 = dijkstra(1, v1) + dijkstra(v2, N) + dijkstra(v1, v2);
        int route2 = dijkstra(1, v2) + dijkstra(v1, N) + dijkstra(v2, v1);
        int result = Math.min(route1, route2) ;

        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);

        }

    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pollNode = poll.getNode();
            if (!visited[pollNode]) {
                visited[pollNode] = true;
                for (Node node : A[pollNode]) {
                    int nextNode = node.getNode();
                    int weight = node.getWeight();
                    if (distance[nextNode] > distance[pollNode] + weight) {
                        distance[nextNode] = weight + distance[pollNode];
                        queue.add(new Node(nextNode, distance[nextNode]));
                    }
                }
            }
        }
        return distance[end];
    }
    private static class Node implements Comparable<Node>{
        int node;
        int weight;

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
}
