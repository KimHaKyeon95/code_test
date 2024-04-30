package practice.스택과큐.백준1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<String> result = new ArrayList<>();
        boolean noFlag = true;
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for (int i = 0; i < N; i++) {
            //현재 수열의 수가 입력되는 값보다 크거나 같을 때
            if (A[i] >= num) {
                //만약 현재 입력값 num이 A[i]보다 작다면 A[i]와 같을 때까지 스택에 값을 push하고 num++를 진행
                while(A[i] >= num) {
                    stack.push(num);
                    result.add("+");
                    num++;
                }
                //값을 다 더해서 num이 A[i]보다 1이 커지면 스택에서 값을 pop()
                //이 때 pop()한 값은 A[i]와 동일한 값이 된다
                //ex) while문에서 num=4일 때 4가 stack에 push가 되고 num은 5가 됨.
                //그 후에 stack의 가장 나중값 4는 A[i]와 동일한 값이 되기 때문에 pop을 하여 제거해줌
                //반복문을 다시 돌릴 때는 A[i]=3이기 때문에 num=5보다 값이 작이 else문을 실행하게 됨
                stack.pop();
                result.add("-");
            } else {
                //현재값 num이 A[i]보다 큰 경우 스택에서 가장 나중값을 제거해준다
                int pop = stack.pop();

                //이 때, 스택의 가장 위의 값이 들어가야하는 값보다 크면 원하는 수열을 만드는 것은 불가능하다.
                if(pop > A[i]) {
                    System.out.println("NO");
                    noFlag = false;
                    break;
                } else {
                    result.add("-");
                }
            }
        }

        if (noFlag) {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
