import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
N^2 개의 수를 입력되는데 이 중 N번째 큰 수를 찾아서 출력하라

# 풀이 논리 #
내림차순 정렬해서 N번째 큰 수를 출력하면 되므로 우선순위 큐를 사용한다.
*/


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 내림차순 정렬을 하는 우선순위 큐에 N * N 표의 수들을 넣는다.
        Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        // N 번째 수를 찾아 출력한다.
        for (int i = 1; i < N; i++) {
            pq.poll();
        }
        System.out.print(pq.poll());
    }
}