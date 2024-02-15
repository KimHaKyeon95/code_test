package practice.그래프.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 트리 {

    private static ArrayList<Integer>[] edges;
    private static int answer = 0;
    private static int deleteNode = 0;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        int root = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node != -1) {
                edges[i].add(node);
                edges[node].add(i);
            } else {
                root = i;
            }
        }

        st = new StringTokenizer(br.readLine());
        deleteNode = Integer.parseInt(st.nextToken());

        if(deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }
    }


    private static void dfs(int a) {
        visited[a] = true;
        int cNode = 0;
        for (int i : edges[a]) {
            if (!visited[i] && i != deleteNode) {
                cNode++;
                dfs(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }

}

