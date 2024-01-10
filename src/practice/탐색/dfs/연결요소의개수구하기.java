package practice.탐색.dfs;

import java.io.*;
import java.util.*;

public class 연결요소의개수구하기 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        A = new ArrayList[node+1];
        visited = new boolean[node+1];

        for (int i = 1; i < node+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        int count = 0;
        for (int i = 1; i < node+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(A[i]);
            }
        }
        System.out.println(count);

    }

    private static void dfs(ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            if (!visited[(int) a.get(i)]) {
                visited[(int) a.get(i)] = true;
                dfs(A[(int) a.get(i)]);
            }
        }
    }


}
