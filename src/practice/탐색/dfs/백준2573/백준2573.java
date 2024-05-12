package practice.탐색.dfs.백준2573;

import java.util.*;
import java.io.*;

public class 백준2573 {

    public static int N;
    public static int M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static ArrayList<Node>[][] A;
    public static int[][] B;
    public static boolean[][] visited;
    public static int linkCount;
    public static int iceCount;
    public static int year = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
                A[i][j] = new ArrayList<>();
            }
        }


        while (true) {
            linkCount = 0;
            iceCount = 0;
            visited = new boolean[N][M];
            initializeArrayList();
            if(iceCount == 0) {
                System.out.println(0);
                break;
            }
            activateDfs();

            if (linkCount >= 2) {
                System.out.println(year);
                break;
            } else {
                melting();
                year++;
            }
        }
    }

    private static void initializeArrayList() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = new ArrayList<>();
            }
        }
        //인접리스트 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] > 0) {
                    iceCount++;
                    int x = i;
                    int y = j;
                    for (int k = 0; k < 4; k++) {
                        if (B[x+dx[k]][y+dy[k]] > 0) {
                            A[i][j].add(new Node(x+dx[k], y+dy[k]));
                        }
                    }
                }
            }
        }
    }

    private static void activateDfs() {

        //dfs실행
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (!visited[i][j] && B[i][j] != 0) {
                    linkCount++; //연결개수
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (Node node : A[row][col]) {
            if (!visited[node.row][node.col]) {
                dfs(node.row, node.col);
            }
        }
    }

    //빙하 녹이기
    private static void melting() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (B[i][j] > 0){
                    int meltingCount = 4 - A[i][j].size();
                    B[i][j] -= meltingCount;
                    if (B[i][j] < 0) {
                        B[i][j] = 0;
                    }
                }
            }
        }
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}