package practice.스택과큐.백준17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] answer = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        //처음에는 스택이 비어있으니 인덱스 0을 넣음
        stack.push(0);

        for (int i = 1; i < N; i++) {
            //스택이 비어있지 않으면서 현재 선택된 수열의 값이 스택의 인덱스에 대한 수열값보다 큰경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        //위의 과정이 전부 진행된 후 스택에 남아있는 인덱스들은 오큰수를 구할 수 없기 때문에 남아있는 것으로 전부 -1처리를 한다
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        //System.out.print를 사용하면 시간초과가 발생하므로 상대적으로 빠른 BufferedWriter를 사용함
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
