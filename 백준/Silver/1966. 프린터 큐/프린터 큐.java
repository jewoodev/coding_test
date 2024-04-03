import java.io.*;
import java.util.*;

/* FIFO에 따라 명령을 담은 후 순서대로 중요도를 확인하고, 모든 문서 중 중요도가 제일 높은게 아니라면 마지막 순번에 옮기는 것을 반복한다
* 그렇지 않다면, 출력한다.
* ========================================
* 위와 같은 논리를 구현하기 위해 큐에서의 순서값과 우선순위 값을 갖는 Document 객체를 우선순위 큐(우선순위 기준 내림차순)에 넣고,
* 해당 순번의 값을 출력하도록 구현한다. */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 리스트에 저장
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 큐에서 순번
            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // 우선순위 큐에 주어지는 순서에 따라 문서를 저장
                int nIpt = Integer.parseInt(st.nextToken());
                q.offer(new Document(j, nIpt));
                pq.offer(nIpt);
            }

            int j = 0;
            int answer = 0;
            // 큐의 몇 번째 문서가 요구사항대로라면 몇 번째로 인쇄되는지 출력한다
            while (true) {
               if (q.peek().ipt == pq.peek()) {
                    answer = q.poll().seq;
                    j++;
                    if (answer  == M) break;
                    pq.poll();
                } else {
                    q.offer(q.poll());
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
