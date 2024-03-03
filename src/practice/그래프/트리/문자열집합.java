package practice.그래프.트리;

import java.io.*;
import java.util.*;

public class 문자열집합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tNode root = new tNode();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            tNode now = root;
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a'];
                if (j == text.length() - 1) {
                    now.isEnd = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            tNode now = new tNode();
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if (j == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }



}

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;
}
