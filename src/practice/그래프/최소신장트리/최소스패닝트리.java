package practice.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최소스패닝트리 {


    private static ArrayList<Edge> edges = new ArrayList<>();

    private static int[] parent;

    private static int edgesNum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];

        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        edgesNum = 0;
        int result = 0;
        for (int i = 0; i < E; i++) {
            if (edgesNum == V-1) {
                break;
            }
            if (find(edges.get(i).start) != find(edges.get(i).end)) {
                union(edges.get(i).start, edges.get(i).end);
                edgesNum++;
                result += edges.get(i).weight;
            }
        }

        System.out.println(result);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        int n = find(a);
        int m = find(b);

        if (n != m) {
            parent[m] = n;
        }
    }

    private static class Edge {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}

