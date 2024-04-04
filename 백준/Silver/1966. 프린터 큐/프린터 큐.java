import java.io.*;
import java.util.*;

/* # 요구사항 정리 #
1. FIFO에 따라 명령을 담은 후 순서대로 중요도를 확인하고, 모든 문서 중 중요도가 제일 높은게 아니라면 마지막 순번에 옮기는 것을 반복한다
2. 그렇지 않다면, 출력한다.
===============================================================================================================
위와 같은 논리를 구현하기 위해 순서값과 우선순위 값을 갖는 Document 객체를 담는 큐를 구현하고,
주어진 문서들을 우선순위가 높은 순서대로 인쇄하기 위해 우선순위 큐에 중요도 값을 넣는다.
큐의 맨 앞에 있는 문서의 중요도 값과 우선순위 큐의 맨 앞에 있는 중요도 값이 같지 않다면 큐에서 꺼내 큐에 다시 넣는다.(요구사항 1번)
그렇지 않다면, 출력한다.(요구사항 2번)
해당 순번의 값을 출력하도록 구현한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 저장하는 로직 시작
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 큐에서 순번
            Queue<Document> q = new LinkedList<>(); 
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // 우선순위 큐에 주어지는 순서에 따라 문서를 저장
                int nIpt = Integer.parseInt(st.nextToken()); // 주어지는 문서들의 중요도 값을 차례대로 저장
                q.offer(new Document(j, nIpt)); // 큐에 문서를 넣고
                pq.offer(nIpt); // 우선순위 큐에 중요도 값을 넣는다
            }

            int j = 0;
            int answer = 0; // 인쇄되는 문서가 큐에서 몇번째였는지 저장하는 값
            // 인쇄 로직 시작
            while (true) {
               if (q.peek().ipt == pq.peek()) { // 
                    answer = q.poll().seq; // 요구사항 2번
                    j++;
                    if (answer  == M) break; // 찾고자 하는 문서가 출력이 됐다면 루프를 벗어난다
                    pq.poll();
                } else {
                    q.offer(q.poll()); // 요구사항 1번
                }
            }
            sb.append(j).append("\n");
        }
        System.out.print(sb);
    }

    private static class Document {
        int seq; // 큐에서 순서
        int ipt; // 중요도
        private Document(int seq, int ipt) {
            this.seq = seq;
            this.ipt = ipt;
        }
    }
}
