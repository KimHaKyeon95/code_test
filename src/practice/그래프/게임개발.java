package practice.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발 {

    private static int[] enter;
    private static ArrayList<Integer>[] A;
    private static int[] time;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        enter = new int[N+1];
        time = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int buildTime = Integer.parseInt(st.nextToken());
            time[i] = buildTime;

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                A[node].add(i);
                enter[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < N+1; i++) {
            if (enter[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[N+1];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : A[node]) {
                result[i] = Math.max(result[i], result[node] + time[node]);
                enter[i]--;
                if (enter[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.println(time[i] + result[i]);
        }
    }

}
