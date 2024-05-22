package practice.그래프.백준1238;


import java.io.*;
import java.util.*;

public class 백준1238 {

    private static int N;
    private static int M;
    private static int X;
    private static ArrayList<Node>[] A;
    private static boolean[] visited;
    private static int[] distance;
    private static int INF = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[a].add(new Node(b, c));
        }

        //X에서 모든 정점까지의 최단거리
        int[] distance1 = dijkstra(X);
        //다른 정점에서 X까지의 최단거리
        for (int i = 1; i < N+1; i++) {
            int[] distance2 = dijkstra(i);
            distance1[i] = distance2[X] + distance1[i];
        }
        Arrays.sort(distance1);
        System.out.println(distance1[N-1]);
    }

    private static int[] dijkstra(int start) {
        visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int nowNode = pollNode.getNextNode();
            if (!visited[nowNode]) {
                visited[nowNode] = true;
                for (Node node : A[nowNode]) {
                    int nextNode = node.getNextNode();
                    int weight = node.getWeight();
                    if(distance[nextNode] > distance[nowNode] + weight) {
                        distance[nextNode] = distance[nowNode] + weight;
                        queue.add(new Node(nextNode, distance[nextNode]));
                    }
                }
            }
        }
        return distance;
    }

    private static class Node implements Comparable<Node>{
        int nextNode;
        int weight;

        public int getNextNode() {
            return nextNode;
        }

        public int getWeight() {
            return weight;
        }

        public Node(int edge, int weight) {
            this.nextNode = edge;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
