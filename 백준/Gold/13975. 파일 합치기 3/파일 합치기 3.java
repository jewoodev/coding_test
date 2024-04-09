import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #


# 풀이 논리 #

*/

class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
            Queue<Long> pq = new PriorityQueue<>(); // 각 장을 저장할 우선순위 큐
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            long accumulateSum = 0;
            while (pq.size() > 1) {
                sum = pq.poll() + pq.poll();
                accumulateSum += sum;
                pq.offer(sum);
            }
            sb.append(accumulateSum).append("\n");
        }
        System.out.print(sb);
    }
}