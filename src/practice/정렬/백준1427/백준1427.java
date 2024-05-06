package practice.정렬.백준1427;

import java.util.*;
import java.io.*;
public class 백준1427 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String[] A = S.split("");
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = Integer.parseInt(A[i]);
        }

        for (int i = 0; i < B.length-1; i++) {
            for (int j = i+1; j < B.length; j++) {
                if (B[i] < B[j]) {
                    int temp = B[i];
                    B[i] = B[j];
                    B[j] = temp;
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]);
        }
    }

}
