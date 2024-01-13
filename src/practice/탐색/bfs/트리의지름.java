package practice.탐색.bfs;

import java.util.*;
import java.io.*;

/*
1시간 시도
기존의 BFS문제와 동일하게 방문 여부를 체크하고 방문마다 결과값에 거리를 더해서
최종적으로 더 큰 값을 구하려했음.
-> 가장 긴 거리의 수를 구하기엔 부적합한 방법. 우선 어떤 케이스가 가장 긴 케이스인지 비교하는 법이 정의돼야함
 */
public class 트리의지름 {

    private static boolean[] visited;
    private static int[] distance;
    private static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];

        /*
        규칙: 임의의 노드에서 가장 긴 경로로 연결된 노드는
        트리의 지름에 해당하는 두가지 노드 중 하나이다.
         */
        //임의의 노드 1부터 시작
        bfs(1);
        int max = 1;
        for (int i = 2; i < N+1; i++) {
            //1노드에서 진행 후 가장 거리값이 큰 노드를 결정
            if (distance[max] < distance[i]) {
               max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        //가장 거리값이 큰 노드를 기준으로 bfs를 실행하면 트리의 지름값을 구할 수 있음
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (Edge edge : A[nowNode]) {
                int e = edge.edge;
                int v = edge.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[nowNode] + v;
                }
            }
        }
    }
}

class Edge {
    int edge;
    int value;

    public Edge(int edge, int value) {
        this.edge = edge;
        this.value = value;
    }
}
