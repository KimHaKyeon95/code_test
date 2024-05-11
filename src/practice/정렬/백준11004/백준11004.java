package practice.정렬.백준11004;

import java.util.*;
import java.io.*;

public class 백준11004 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);

        System.out.println(A[K-1]);

    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivot = findPivot(A, start, end);
            if (pivot == K) {
                //pivot이 현재 구하고자 하는 자리와 일치하면 그냥 K번째 자리값을 출력
                return;
            } else if (pivot > K) {
                //pivot이 현재 구하고자 하는 자리보다 크면 pivot기준 오른쪽만 정렬
                quickSort(A, start, pivot-1, K);
            } else {
                //pivot이 현재 구하고자 하는 자리보다 작으면 pivot기준 왼쪽만 정렬
                quickSort(A, pivot+1, end, K);
            }
        }
    }

    //피벗을 구하는 메서드
    public static int findPivot(int[] A, int start, int end) {
        //정렬 요소가 2개면 swap하고 종료
        if (start+1 == end) {
            if (A[start] > A[end]) {
                swap(A, start, end);
                return end;
            }
        }

        //중간요소
        int mid = (start+end) / 2;

        //pivot으로 지정된 중간요소와 제일 처음요소 swap
        swap(A, start, mid);
        int pivot = A[start];

        int i = start+1;
        int j = end;

        while(i <= j) {
            //피벗을 기준으로 이보다 작은 수가 나올 때까지 j를 왼쪽으로 옮김
            while (j >= start+1 && A[j] > pivot) {
                j--;
            }

            //피벗을 기준으로 이보다 큰 수가 나올 때까지 i를 왼쪽으로 옮김
            while (i <= end && A[i] < pivot) {
                i++;
            }
            if (i <= j) {
                //pivot보다 작은 값인 A[j]와 pivot보다 큰 값인 A[i]를 swap하고 i와 j를 옮김
                swap(A, i, j);
                i++;
                j--;
            }
        }

        /**
         * 현재 pivot인 값을 i와 j가 만난 자리와 값을 바꿔줌
         * -> 옮겨진 pivot을 기준으로 양 옆 영역의 값이 pivot보다 작고 큰 값으로 나눠지게 됨
         */
        A[start] = A[j];
        A[j] = pivot;

        //현재 pivot의 좌표를 리턴
        return j;
    }


    //두 요소의 자리를 바꾸는 메서드
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}