package practice.정렬.백준2751;

import java.util.*;
import java.io.*;

public class 백준2751 {

    public static int[] A;
    public static int[] temp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        temp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(1, N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < N+1; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        //분할된 배열의 길이가 1일 때
        if (end - start < 1) {
            return;
        }

        //분할의 기준이 되는 중간값
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        //주어진 구간 전체를 2분할한 후 병합정렬 실행
        int k = start;
        //분할된 왼쪽 배열의 첫번째 인덱스
        int index1 = start;
        //분할된 오른쪽 배열의 첫번째 인덱스
        int index2 = mid+1;

        while (index1 <= mid && index2 <= end) {
            //분할된 두개의 배열중 작은 값을 A에 저장
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                index2++;
                k++;
            } else {
                A[k] = temp[index1];
                index1++;
                k++;
            }
        }
        //남은 수들 소진하기
        while(index1 <= mid) {
            A[k] = temp[index1];
            index1++;
            k++;
        }
        while(index2 <= end) {
            A[k] = temp[index2];
            index2++;
            k++;
        }
    }
}


