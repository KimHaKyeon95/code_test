package practice.그래프.유니온파인드;

import java.io.*;
import java.util.*;

public class 집합의표현 {

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int kind = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (kind == 0) {
                union(a, b);
            } else {
                boolean isSame = checkSame(a, b);
                if (isSame) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        int n = find(a);
        int m = find(b);
        if (n != m) {
            parent[n] = m;
        }
    }

    private static int find (int a) {
        if (parent[a] == a) {
            return a;
        } else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

    private static boolean checkSame (int a, int b) {
        int n = find(a);
        int m = find(b);
        if (n == m) {
            return true;
        }
        return false;
    }

}
