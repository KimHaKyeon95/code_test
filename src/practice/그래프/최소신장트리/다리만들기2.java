package practice.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {

    private static int N;
    private static int M;
    private static int sNum;
    private static int[][] map;
    private static ArrayList<Edge> edges = new ArrayList<>();

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;

    private static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    sNum++;
                }
            }
        }
        parent = new int[sNum];
        for (int i = 1; i < sNum; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                findBridge(i, j);
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        int edgesNum = 0;
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (edgesNum == sNum-2) {
                break;
            }
            if (find(edges.get(i).start) != find(edges.get(i).end)) {
                union(edges.get(i).start, edges.get(i).end);
                edgesNum++;
                result += edges.get(i).weight;
            }
        }

        if (edgesNum == sNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {i, j};
        queue.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            for (int d = 0; d < 4; d++) {
                int r = dx[d];
                int c = dy[d];
                int tempRow = row + r;
                int tempCol = col + c;
                while (tempRow >= 0 && tempRow < N && tempCol >= 0 && tempCol < M) {
                    if (visited[tempRow][tempCol] == false && map[tempRow][tempCol] != 0) {
                        visited[tempRow][tempCol] = true;
                        queue.add(new int[]{tempRow, tempCol});
                        map[tempRow][tempCol] = sNum;
                    } else {
                        break;
                    }
                    if (r < 0) {
                        r--;
                    } else if (r > 0) {
                        r++;
                    } else if (c < 0) {
                        c--;
                    } else if (c > 0) {
                        c++;
                    }
                }
            }
        }
    }

    private static void findBridge(int a, int b) {
        int currentIsland = map[a][b];
        for (int d = 0; d < 4; d++) {
            int row = a;
            int col = b;
            int length = 0;

            while (true) {
                row += dx[d];
                col += dy[d];

                if (row < 0 || row >= N || col < 0 || col >= M) {
                    break;
                }
                if (map[row][col] == currentIsland) {
                    break;
                }

                if (map[row][col] != 0) {
                    if (length > 1) {
                        int otherIsland = map[row][col];
                        edges.add(new Edge(currentIsland, otherIsland, length));
                    }
                    break;
                }
                length++;
            }
        }
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

