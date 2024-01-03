package practice.정수론;

import java.util.Scanner;

public class 소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];
        for(int i = 2; i < N+1; i++) {
            A[i] = i;
        }

        //Math.sqrt(N) -> N = a * b에서 a 또는 b가 N보다 클 수 없음
        // a, b중 N의 제곱근보다 크지 않은 수의 배수는 소수가 아닌 수로 다 걸러지기 때문에 N의 제곱근까지만 탐색하면 됨
        for (int i = 2; i <= Math.sqrt(N); i++) {
            //0이면 넘어감
            if (A[i] == 0) {
                continue;
            }
            //배수만 지우기
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }
        
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }

}
