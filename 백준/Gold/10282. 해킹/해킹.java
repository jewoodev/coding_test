import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 총 감염되는 컴퓨터 수, 마지막 것까지 감염되는데 소요되는 시간
    static int totalCnt, totalTime, n;

    // 컴퓨터끼리의 의존 관계를 저장할 배열
    static List<Computer>[] dependArr;

    // 컴퓨터 번호(인덱스 번호)가 감염되는데 걸리는 시간의 최소값을 저장할 배열
    static int[] times;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 케이스를 연산하는 루프
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호

            times = new int[n + 1];
            dependArr = new List[n + 1]; // 의존성 정보를 저장하기 위해 초기 세팅
            for (int j = 1; j <= n; j++) {
                dependArr[j] = new ArrayList<>();
                times[j] = Integer.MAX_VALUE;
            }

            // 의존성 정보를 저장한다.
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // a가
                int b = Integer.parseInt(st.nextToken()); // b를 의존하고
                int s = Integer.parseInt(st.nextToken()); // b가 감염되면 a도 s초 후에 감염된다.
                dependArr[b].add(new Computer(a, s));
            }

            Dijkstra(c);

            // 결과값 산출
            totalCnt = 0;
            totalTime = 0;
            for (int j = 1; j <= n; j++) {
                if (times[j] != Integer.MAX_VALUE) {
                    totalCnt++;
                    totalTime = Math.max(totalTime, times[j]);
                }
            }
            sb.append(totalCnt).append(" ").append(totalTime).append("\n");
        }
        System.out.print(sb);
    }

    static void Dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Computer> q = new PriorityQueue<>();
        times[start] = 0; // 시작점의 소요시간을 0으로 초기화한다.
        q.offer(new Computer(start, 0));

        while (!q.isEmpty()) {
            Computer now = q.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Computer next : dependArr[now.end]) { // 감염된 컴퓨터의 end 관계의 컴퓨터를 가져와서
                    // 그 컴퓨터의 end 컴퓨터의 times 배열 값보다 이번에 확인한 소요시간이 더 짧으면
                    if (times[next.end] > times[now.end] + next.time) {
                        times[next.end] = times[now.end] + next.time;
                        q.offer(new Computer(next.end, times[next.end]));
                    }
                }
            }
        }
    }

    static class Computer implements Comparable<Computer> {
        // 감염될 컴 번호, 소요 시간
        int end, time;
        Computer(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}
