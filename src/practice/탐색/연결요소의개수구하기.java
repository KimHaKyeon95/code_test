package practice.탐색;

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

        visited = new boolean[node+1];
        A = new ArrayList[node+1];
        for(int i = 1; i < node+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        int count = 0;
        for (int i = 1; i < node+1; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }

    static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}
