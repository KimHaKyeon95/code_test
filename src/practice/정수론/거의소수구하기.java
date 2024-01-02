package practice.정수론;

import java.util.Scanner;

public class 거의소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int result = 0;

        long[] arr = new long[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i+i; j < arr.length; j = j+i) {
                arr[j] = 0;
            }
        }

        /*
        해당 부분에서 30분 정도 시도함.
        제곱근을 계속 늘려주고 result를 ++해줘야 하는데 제곱근을 계속 늘리면서 임계치에 도달했을 때
        반복문을 중지하는 로직이 생각나지 않음
        */
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];
                while (arr[i] <= B/temp) {
                    if (arr[i] >= A/temp) {
                        result++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
        /*
        위와 같이 temp에 현재 제곱근을 저장하고 최대값/현재제곱근보다 소수의 값이 더 작거나 같은 동안만 실행하면서
        최소값/현재제곱근보다 소수의 값이 크거나 같다라는 조건을 걸어주면 구현이 가능함.
         */
        System.out.println(result);

    }

}
