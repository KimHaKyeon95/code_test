package practice.그래프;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

    public static int[] result;
    private static boolean[] visited;
    private static ArrayList<Bus>[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[N+1];

        A = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<Bus>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            A[depart].add(new Bus(arrive, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        result[start] = 0;

        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(start, 0));

        while (!queue.isEmpty()) {
            Bus bus = queue.poll();
            int busArrive = bus.arrive;
            if(!visited[busArrive]) {
                visited[busArrive] = true;
                for (Bus b : A[busArrive]) {
                    if (!visited[b.arrive]) {
                        result[b.arrive] = Math.min(result[b.arrive], b.cost + result[busArrive]);
                        queue.add(new Bus(b.arrive, result[b.arrive]));
                    }
                }
            }
        }

        System.out.println(result[end]);
    }
}

class Bus implements Comparable<Bus>{
    int arrive;
    int cost;

    public Bus(int arrive, int cost) {
        this.arrive = arrive;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus bus) {
        return cost - bus.cost;
    }
}
