package practice.정수론;

import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int[] A = new int[1004000];

        for (int i = 2; i < 1004000; i++) {
            A[i] = i;
        }

        //소수 찾는 구간
        for (int i = 2; i < Math.sqrt(1004000); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i+i; j < 1004000; j = j+i) {
                A[j] = 0;
            }
        }

        //팰린드롬수 찾는 구간
        int i = N;
        while (true) {
            if (A[i] != 0) {
                int ressult = A[i];
                if (isPalindrome(ressult)) {
                    System.out.println(ressult);
                    break;
                }
            }
            i++;
        }

    }

    private static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int startIndex = 0;
        int endIndex = temp.length - 1;

        while (startIndex < endIndex) {
            if (temp[startIndex] != temp[endIndex]) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
