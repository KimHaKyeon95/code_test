package practice.정수론;

import java.util.Scanner;

public class 최소공배수구하기 {
    private static int gcdResult;
    private static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A > B) {
                gcd(A, B);
            } else {
                gcd(B, A);
            }
            result = A * B / gcdResult;
            System.out.println(result);
        }

    }

    private static void gcd(int A, int B) {
        int result = A % B;
        if (result == 0) {
            gcdResult = B;
        } else {
            gcd(B, result);
        }
    }

}
