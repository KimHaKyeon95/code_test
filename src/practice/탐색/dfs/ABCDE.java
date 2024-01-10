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

    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    private static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        A = new ArrayList[node+1];
        visited = new boolean[node+1];

        for (int i = 1; i < node+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        for (int i = 0; i < node; i++) {
            if (arrive) {
                break;
            }
        }

        if(arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }

    private static void dfs(int now, int depth) {
        if (depth == 5 || arrive) { //이미 원하는 케이스를 찾았을 때는 arrive가 true이므로 재귀문 종료
            arrive = true;
            return;
        } else {
            visited[now] = true;
            for(int i : A[now]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false;
        //이미 다음 노드를 향해 dfs를 실행했으므로 방문여부의 초기화를 통해 다른 탐색도 해당 노드를 방문
    }
}
