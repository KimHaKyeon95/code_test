package practice.정수론;

import java.util.Scanner;

public class 최대공약수 {

    private static long gcdResult;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        if (A > B) {
            gcd(A, B);
        } else {
            gcd(B, A);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcdResult; i++) {
            sb.append("1");
        }

        System.out.println(sb);
    }

    private static void gcd(long A, long B) {
        long result = A % B;
        if (result == 0) {
            gcdResult = B;
        } else {
            gcd(B, result);
        }
    }

}
