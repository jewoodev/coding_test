import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 자료구조 개수
        int[] arr = new int[N];
        ArrayDeque<Integer> dq = new ArrayDeque<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int element = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) dq.offer(element);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            dq.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}