package practice.정렬.백준2750;

import java.util.*;
import java.io.*;

public class 백준2750 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            A[i] = input;
        }

        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (A[j] > A[j+1]) {
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}
