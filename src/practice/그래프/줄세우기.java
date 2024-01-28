package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {

    private static int[] enter;
    private static ArrayList<Integer>[] A;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        enter = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            enter[b]++;
        }

        Queue queue = new LinkedList<Integer>();
        for (int i = 1; i < enter.length; i++) {
            if (enter[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = (int) queue.poll();
            System.out.print(node + " ");
            for (int i : A[node]) {
                enter[i]--;
                if (enter[i] == 0) {
                    queue.add(i);
                }
            }

        }

    }

}
