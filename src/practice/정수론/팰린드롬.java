package practice.정수론;

import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int[] A = new int[1000001];

        for (int i = 2; i < 1000001; i++) {
            A[i] = i;
        }

        //소수 찾는 구간
        for (int i = 2; i < Math.sqrt(1000001); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i+i; j < 1000001; j = j+i) {
                A[j] = 0;
            }
        }

        //팰린드롬수 찾는 구간
        for (int i = N; i < 1000001; i++) {
            if (result != 0) {
                break;
            }
            char[] number = Integer.toString(A[i]).toCharArray();
            if (number.length >= 3) {
                int startIndex = 0;
                int endIndex = number.length - 1;
                while (number[startIndex] == number[endIndex - startIndex]) {
                    if (startIndex == endIndex - startIndex) {
                        result = i;
                        break;
                    }
                    startIndex++;
                }
            }
        }
        System.out.println(result);

    }

}
