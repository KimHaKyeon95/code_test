package practice.탐색.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
30분 고민함
탐색 깊이가 5일 때 or 지나온 엣지의 개수가 4일 때 1을 반환하도록 하려함
그런데 dfs로 한번 탐색을 종료할 때 방문여부와 결과값을 초기화하는 방법이 생각나지 않음
 */
public class ABCDE {

    //인접 리스트
    private static ArrayList<Integer>[] A;

    //각 노드의 방문 여부
    private static boolean[] visited;

    //엣지의 개수가 5개면 true로 변경될 값
    private static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visited = new boolean[node];
        A = new ArrayList[node];
        arrive = false;
        for (int i = 0; i < node; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < node; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i: A[now]) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
        visited[now] = false;
    }
}
