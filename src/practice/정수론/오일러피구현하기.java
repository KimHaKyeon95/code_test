package practice.정수론;

import java.util.Scanner;

public class 오일러피구현하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;

        for (long p = 2; p <=Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            result = result - result / n;
        }
        System.out.println(result);
    }

}
