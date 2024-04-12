import java.util.*;
import java.io.*;

public class Main {
    private static int N, answer, problemCnt;
    private static int[][] cave; // 동굴
    private static List<Integer> list = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 원생 수
        problemCnt = 1;
        while (true) {
            init(); // 테스트 케이스마다 초기화
            BFS();
            write(); // 테스트 케이스마다 결과 write
            problemCnt++;
            if ((N = Integer.parseInt(br.readLine())) == 0) break;
        }
        System.out.print(sb);
    }

    private static void init() throws IOException {
        cave = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                cave[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void BFS() {
        Queue<Link> q = new PriorityQueue<>(125);

        int[][] moneyNote = new int[N][N]; // 방문하며 드는 비용을 최솟값일 때만 갱신시킬 배열
        for (int i = 0; i < N; i++) {
            Arrays.fill(moneyNote[i], Integer.MAX_VALUE);
        }

        q.offer(new Link(0, 0, cave[0][0]));
        moneyNote[0][0] = cave[0][0];

        while (!q.isEmpty()) {
            Link now = q.poll();

            if (now.r == N - 1 && now.c == N - 1) {
                answer = now.money;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];
                if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
                if (now.money + cave[nR][nC] < moneyNote[nR][nC]) {
                    moneyNote[nR][nC] = now.money + cave[nR][nC];
                    q.offer(new Link(nR, nC, now.money + cave[nR][nC]));
                }
            }
        }
    }

    private static void write() {
        sb.append("Problem ").append(problemCnt).append(":")
                .append(" ").append(answer).append("\n");
    }

    private static class Link implements Comparable<Link> {
        // 좌표 위치, 금액
        int r, c, money;
        private Link(int r, int c, int money) {
            this.r = r;
            this.c = c;
            this.money = money;
        }

        @Override
        public int compareTo(Link l) {
            return this.money - l.money;
        }
    }
}