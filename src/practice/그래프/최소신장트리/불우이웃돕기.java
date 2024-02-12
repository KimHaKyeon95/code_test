package practice.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 불우이웃돕기 {

    private static int[] parents;
    private static ArrayList<Edge> edges;
    private static int total;
    private static int edgesNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        edges = new ArrayList<Edge>();
        total = 0;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            String[] length = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                char a = length[j].charAt(0);
                int value = (int) a;
                if (value == 48) {
                    value = 0;
                } else if (value < 97) {
                    value = value - 38;
                } else {
                    value = value - 96;
                }
                total += value;
                if (value != 0) {
                    edges.add(new Edge(i, j+1, value));
                    edges.add(new Edge(j+1, i, value));
                }
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        edgesNum = 0;
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (edgesNum == N-1) {
                break;
            }
            if (find(edges.get(i).start) != find(edges.get(i).end)) {
                union(edges.get(i).start, edges.get(i).end);
                edgesNum++;
                result += edges.get(i).weight;
            }
        }

        if (edgesNum < N-1) {
            System.out.println(-1);
        } else {
            System.out.println(total - result);
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        parents[a] = find(parents[a]);
        return parents[a];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
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
