package practice.스택과큐.백준2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2164 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }

        int poll = 0;
        while (true) {
            if (queue.size() == 1) {
                poll = queue.poll();
                break;
            }
            queue.remove();
            int temp = queue.poll();
            queue.add(temp);
        }

        System.out.println(poll);
    }
}
