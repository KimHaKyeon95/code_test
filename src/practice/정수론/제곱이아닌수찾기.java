package practice.정수론;

import java.util.Scanner;

public class 제곱이아닌수찾기 {

    /*
    40분 시도
    기존에 시도했던 에라토스테네스의 체
    for (int i = 2; i < Math.sqrt(max); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i * i; j < A.length; j = j * i) {
                A[j] = 0;
            }
        }
        위와 같은 방법을 활용해서 진행하면 j * i에서 제곱수를 건너뛰는 일이 발생함 -> 범위 커지면 값이 안나옴
        ->
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] check = new boolean[(int)(max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }
            /*
            제곱수(pow)에 배수를 걸러야 하므로 범위를 pow * j로 설정한다.
            check배열에서 인덱스가 현재 인덱스(startIndex) * 제곱수(pow) - 최소수(min)인 부분을 true로 변경한다.
            순서가 제곱수(pow)설정 -> 제곱수에 1씩 더해지는 수 j를 곱해서 제곱수로 나눠 떨어지는 수를 찾기 이다.
             */
            for (long j = startIndex; pow * j <= max; j++) {
                check[(int)((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

}
