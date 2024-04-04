import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 자연수가 적힌 N 장의 카드에서 두 장을 골라서 그 두 카드에 쓰인 수를 두 수를 더한 값으로 바꾸는 연산을 M 번 해서
2. 모든 카드의 수를 더한 값이 최소가 될 때의 값을 출력하라

# 풀이 논리 #
가장 작은 수부터 더하는 연산을 해야 최솟값이 되므로 우선순위 큐를 이용해 구현한다.

1. 큐에서 꺼낸 두 장을 더해서 그 값으로 카드의 숫자를 바꾸는 연산을 M 번 한다.
2. 모든 카드의 수를 더한 값을 출력하라.

# 오답 포인트 #
long 당했다....
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 카드 갯수
        int M = Integer.parseInt(st.nextToken()); // 요구사항 1번의 연산 횟수
        Queue<Long> pq = new PriorityQueue<>();
        // 카드 번호를 우선순위 큐에 저장하는 로직
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        // 요구사항 1번의 연산 로직
        while (M-- > 0) {
            long cNum = 0; // 카드 번호
            // 풀이 논리 1번
            cNum += pq.poll();
            cNum += pq.poll();
            pq.offer(cNum);
            pq.offer(cNum);
        }
        // 모든 카드의 수의 총합 출력, 풀이 논리 2번
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.print(answer);
    }
}