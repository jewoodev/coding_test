import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. N * M 크기의 연구소 맵에 0은 빈 칸, 1은 벽, 2는 바이러스로 정보가 주어진다. 아직 바이러스는 퍼지지 않았다.
2. 주어진 맵에 3개의 벽을 세운다면 그 경우마다 바뀌는 안전 영역의 크기 중 최댓값을 구하라.

# 풀이 논리 #
1. 현재 맵에 벽을 세우는 모든 경우(1)마다 바이러스를 퍼뜨린 후 안전 영역의 크기를 최댓값으로 갱신(2)하면 된다.
2. (1)과 (2)를 각각 기호에 맞게 그래프 탐색 구현한다.
*/

class Main {
    private static int N, M;
    private static int[][] field, infected;
    private static int maxSpace = Integer.MIN_VALUE; // 안전 영역 최댓값
    private static int[] dX = {-1, 1, 0, 0};
    private static int[] dY = {0, 0, -1, 1};
    private static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        field = new int[N][M]; // 연구소 정보를 저장할 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.print(maxSpace);
        br.close();
    }

    private static void DFS(int wallCnt) { // 벽 세우기
        if (wallCnt == 3) { // 3개의 벽이 세워질 때마다
            BFS(); // BFS
            return;
        }
        for (int i = 0; i < N; i++) { // 벽을 세우는 모든 경우의 수 탐색
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = 1;
                    DFS(wallCnt + 1);
                    field[i][j] = 0;
                }
            }
        }
    }

    private static void BFS() { // 안전 영역 탐색
        q = new LinkedList<>();
        initMap(); // infected 배열 세팅, 바이러스 위치 큐에 저장

        while (!q.isEmpty()) {
            int[] now = q.poll(); // 현재 위치
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nX = x + dX[i]; // 다음으로 방문할 수 있는 위치
                int nY = y + dY[i];
                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue; // 맵을 벗어난다면 continue
                if (infected[nX][nY] == 0) { // 벽이 아닌 인접한 위치에
                    infected[nX][nY] = 2; // 전염이 된다
                    q.offer(new int[] {nX, nY});
                }
            }
        }

        int cnt = 0; // 안전 영역 크기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (infected[i][j] == 0) cnt++;
            }
        }
        maxSpace = Math.max(maxSpace, cnt);
    }

    private static void initMap() {
        infected = new int[N][M]; // 경우마다 사용할 연구소 정보 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                infected[i][j] = field[i][j]; // 원본 배열 copy

                if (infected[i][j] == 2) // 바이러스 위치
                    q.offer(new int[] {i, j}); // 저장
            }
        }
    }
}
