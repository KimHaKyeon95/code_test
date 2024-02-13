package practice.그래프.트리;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    private static int N;
    private static boolean[] visited;
    private static ArrayList<Integer>[] tree;
    private static int[] answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        answer = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);
        for (int i = 2; i < N+1; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int num) {
        visited[num] = true;
        for (int i : tree[num]) {
            if (!visited[i]) {
                answer[i] = num;
                dfs(i);
            }
        }
    }

}
