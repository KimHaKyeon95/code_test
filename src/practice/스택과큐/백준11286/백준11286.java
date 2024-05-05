package practice.스택과큐.백준11286;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int s1 = Math.abs(o1);
            int s2 = Math.abs(o2);

            if (s1 == s2) {
                return o1 > o2 ? 1 : -1;
            } else {
                return s1 - s2;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (input == 0 && !queue.isEmpty()) {
                System.out.println(queue.poll());
            } else if (input == 0 && queue.isEmpty()) {
                System.out.println(0);
            } else {
                queue.add(input);
            }
        }
    }
}
