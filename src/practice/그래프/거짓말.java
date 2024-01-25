package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말 {
    private static int[] parent;
    private static int[] tPeople;
    private static ArrayList<Integer>[] party;
    private static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        result = 0;
        tPeople = new int[T];
        for (int i = 0; i < T; i++) {
            tPeople[i] = Integer.parseInt(st.nextToken());
        }
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<Integer>();
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.valueOf(st.nextToken()));
            }
        }
        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int current = party[i].get(0);
            for (int j = 0; j < tPeople.length; j++) {
                if (find(current) == find(tPeople[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void union (int a, int b) {
        int n = find(a);
        int m = find(b);

        if (n != m) {
            parent[m] = n;
        }
    }

    private static int find (int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }
}
