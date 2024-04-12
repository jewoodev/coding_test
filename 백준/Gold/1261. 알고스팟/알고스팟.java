import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, answer;
    private static int[][] maze; // 동굴
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로 길이
        M = Integer.parseInt(st.nextToken()); // 세로 길이
        init(); // 맵 정보 받기
        BFS();
        System.out.print(answer);
    }

    private static void init() throws IOException {
        maze = new int[M][N];
        for (int r = 0; r < M; r++) {
            String line = br.readLine();
            for (int c = 0; c < N; c++) {
                maze[r][c] = line.charAt(c) - '0';
            }
        }
    }

    private static void BFS() {
        Queue<Operator> q = new PriorityQueue<>();

        q.offer(new Operator(0, 0, 0));
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Operator now = q.poll();

            if (now.r == M - 1 && now.c == N - 1) {
                answer = now.breakTimes;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];
                if (nR < 0 || nC < 0 || nR >= M || nC >= N) continue;
                if (visited[nR][nC]) continue;

                if (maze[nR][nC] == 0) {
                    q.offer(new Operator(nR, nC, now.breakTimes));
                }
                else {
                    q.offer(new Operator(nR, nC, now.breakTimes + 1));
                }
                visited[nR][nC] = true;
            }
        }
    }

    private static class Operator implements Comparable<Operator> {
        // 좌표 위치, 금액
        int r, c, breakTimes;
        private Operator(int r, int c, int breakTimes) {
            this.r = r;
            this.c = c;
            this.breakTimes = breakTimes;
        }

        @Override
        public int compareTo(Operator l) {
            return this.breakTimes - l.breakTimes;
        }
    }
}