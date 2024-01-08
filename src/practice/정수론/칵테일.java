package practice.정수론;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class 칵테일 {

    /*
    1시간 시도
    전체 비율의 최소 공배수를 구하여 제일 많은 비율의 재료를 통해 전체 비율을 알아내면 될 줄 알았음
    아래의 방법에서 런타임 에러가 발생. 어떤 수를 0으로 나눴다는데 어디서 해당 현상이 발생했는지 알 수 없음
     */
//    private static int gcdResult;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] A = new int[N];
//        for (int i = 0; i < N-1; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int p = sc.nextInt();
//            int q = sc.nextInt();
//
//            A[i] = p / q;
//        }
//        A[N-1] = 1;
//
//
//        gcd(A[0], A[1]);
//        //A[0]과 A[1] 사이의 최소 공배수
//        int temp = makeMultiple(A[0], A[1]);
//
//        for (int i = 2; i < N-1; i++) {
//            gcd(temp, A[i]);
//            temp = makeMultiple(temp, A[i]);
//        }
//
//        int result = A[N-1] * temp;
//        for (int i = 0; i < N; i++) {
//            A[i] = result/A[i];
//            System.out.print(A[i] + " ");
//        }
//    }
//
//    private static void gcd(int a, int b) {
//        int result;
//        if (a >= b) {
//            result = a % b;
//        } else {
//            result = b % a;
//        }
//        if (result == 0) {
//            if (a > b) {
//                gcdResult = b;
//            } else {
//                gcdResult = a;
//            }
//        } else {
//            gcd(b, result);
//        }
//    }
//
//    private static int makeMultiple(int a, int b) {
//        return a * b / gcdResult;
//    }

    /*
    최소 공배수는 a * b / 최대공약수 의 수식을 통해 구할 수 있다. 최대 공약수는 유클리드 호제법 사용
    문제를 그래프 관점에서 생각하면 인접리스트, DFS를 사용하여 문제를 풀 수 있다.
     */
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }

        //인접리스트 배열A에 에지정보 저장하기. 최소공배수 값 업데이트하기
        for (int i = 0; i < N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(b, p, q));
            lcm *= (p * q / gcd(p, q));
        }
        //이 시점에 최소 공배수 값은 정해져 있음

        //0번노드(임의의 시작점)에 최소 공배수 저장
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            //D배열은 현재 DFS를 통해 업데이트 된 상태. 해당 값을 최대 공약수로 나d
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i = 1; i < N; i++) {
            System.out.println(D[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    public static void DFS(int Node) {
        visited[Node] = true;
        for (cNode i : A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                //각 노드의 값이 저장된 D배열의 값을 업데이트함
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

}

class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
