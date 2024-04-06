import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 센티는 여행을 가서 만나는 거인 중 자신보다 키가 큰 거인을, 그 중에서 가장 키가 큰 거인을 우선적으로 뿅망치를 때린다.
2. 뿅망치에 맞으면 키가 1이지 않는한 2분의 1로 나눠진다.(소수점 내림)
3. 모든 거인의 키를 센티보다 작게 만드는데 성공했으면 YES와 뿅망치 사용 횟수를,
4, 실패했으면 NO와 마을에서 가장 큰 거인의 키를 출력하라

# 풀이 논리 #
1. 요구사항 2번의 연산과 1번의 연산을 우선순위 큐로 구현한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 거인 수
        int H = Integer.parseInt(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 뿅망치 사용 가능 횟수
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // 뿅망치 맞을 순서대로 거인을 저장할 우선순위 큐
        for (int i = 0; i < N; i++) // 거인의 키 저장
            q.offer(Integer.parseInt(br.readLine()));

        // 자, 이제 때리자
        int use = 0; // 뿅망치 사용 횟수
        while (T > 0 && !q.isEmpty()) {
            if (q.peek() < H) break; // 센티가 보다 다 작다. break.
            else {
                Integer polled = q.poll(); // 큰 놈한테
                q.offer(polled == 1 ? 1 : (int) Math.floor(polled /(double) 2)); // 망치로 혼내준다. 키가 1이 아니라면 요구사항 2번대로 된다.
                T--;
                use++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (q.peek() < H) { // 성공했는지 확인하고
            sb.append("YES\n").append(use); // 요구사항 3번
        }
        else {
            sb.append("NO\n").append(q.peek()); // 요구사항 4번
        }
        System.out.println(sb);
    }
}