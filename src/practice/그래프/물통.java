package practice.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 물통 {

    private static int[] Sender= {0, 0, 1, 1, 2, 2};
    private static int[] Receiver = {1, 2, 0, 2, 0, 1};
    private static boolean[] answer;
    private static boolean[][] visited;
    private static int[] now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true; //now[2]는 처음에 주어진 C물통의 물양. 경우의 수에 추가되어야한다.
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B; //C의 물의 양은 A, B를 빼면 유추가 가능하다.
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                /*
                k = 0일 때
                next[Receiver[0]] = next[1] = B
                next[Sender[0]] = next[0] = A
                B에 A의 물의 양만큼 채우고 A의 값은 0으로 초기화 한다.
                 */
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if (next[Receiver[k]] > now[Receiver[k]]) { //만약 B에 들어오게 될 양이 기존에 주어진 now[1]보다 크다면
                    //next[0]  = next[1] - now[1] -> A의 물의 양은 B의 넘쳐있는 물의 양에서 초기에 주어진 B의 용량만큼 빼면 된다.
                    //그럼 B의 용량 이상만큼은 다시 A로 돌아옴
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    //next[1] B는 꽉 차있는 상태이므로 초기에 정해진 용량으로 초기화해준다.
                    next[Receiver[k]] = now[Receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    //방문여부 체크가 아닌 A, B의 물의 양을 경우의 수로 체크해야됨
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) { //A의 물의 양이 0인 순간
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int a, int b) {
        this.A = a;
        this.B = b;
    }
}
