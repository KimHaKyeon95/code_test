package practice.탐색.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    private static int[][] maze;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int N;
    private static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited= new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        findWay(0, 0);
        System.out.println(maze[N-1][M-1]);

    }

    private static void findWay(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, m});
        visited[n][m] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (maze[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        maze[x][y] = maze[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
