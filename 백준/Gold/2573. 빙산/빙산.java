import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. N * M 크기의 바다 맵에 빙산의 좌표마다 얼음이 숫자로 주어진다(예시: 3). 바닷물은 0으로 주어진다.
2. 각 얼음 좌표마다 그 좌표 상하좌우로 인접한 바닷물의 수(예시: 2)만큼 1년마다 얼음의 숫자가 뺄셈되어진다.(예시 결과 : 3-2 = 1)
3. 빙산이 처음으로 나뉘어지는 시간(년)을 구하라.

# 풀이 논리 #
1. 각 얼음 좌표를 BFS해서 인접한 바닷물 수만큼 얼음을 녹인다.
2. 그 후 DFS로 빙산 개수를 체크한다. 2개가 넘어가면 시간을 출력한다. 다만, 빙산이 다 녹게되면 0을 출력한다.

# Point #
녹는 중에 다 녹아버려서 얼음에 인접하는 바다 수가 늘어났을 때 카운트되는 경우가 발생된다.
그런데 문제의 설명에 있는 예제를 보면 1년이 다 지나고 나서 카운트 하기 때문에
풀이 논리 1번을 할 때마다 각 얼음 좌표는 인접한 바닷물로 체크하는 로직에서 제외시키기 위해 위치 체크를 한다.
*/

class Main {
    private static int N, M;
    private static int[][] field;
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};
    private static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행의 개수
        M = Integer.parseInt(st.nextToken()); // 열의 개수
        field = new int[N][M]; // 맵 정보 저장할 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int glacier = 0; // 빙산 개수
        while ((glacier = countGlacier()) < 2) { // 풀이 논리 2번
            if (glacier == 0) { // 빙산이 다 녹게되면
                answer = 0; // 0을 출력
                break;
            }
            BFS(); // 풀이 논리 1번
            answer++;
        }
        System.out.print(answer);
        br.close();
    }

    private static int countGlacier() {
        boolean[][] visited = new boolean[N][M]; // 방문 여부 배열
        int cnt = 0; // 빙하 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] != 0 && !visited[i][j]) { // 방문하지 않은 얼음을 찾아서
                    DFS(i, j, visited); // 1. DFS
                    cnt++; // DFS로 인접한 얼음을 그룹핑함으로써 카운트
                }
            }
        }
        return cnt;
    }

    private static void DFS(int r, int c, boolean[][] visited) {
        visited[r][c] = true; // (1-1. && 1-3.) 방문
        for (int i = 0; i < 4; i++) {
            int nR = r + dR[i]; // 인접한 위치
            int nC = c + dC[i];
            if (nR < 0 || nC < 0 || nR >= N || nC >= M) continue; // 맵을 벗어나면 continue
            if (field[nR][nC] != 0 && !visited[nR][nC]) // 1-2. 방문하지 않았고 얼음이면
                DFS(nR, nC, visited); // 재귀
        }
    }

    private static void BFS() {
        q = new LinkedList<>();
        boolean[][] check = new boolean[N][M]; // 얼음 위치 체크 배열
        // 빙하가 위치한 좌표들을 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] != 0) {
                    q.offer(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }
        // 얼음마다 녹이는 로직
        while (!q.isEmpty()) {
            int[] now = q.poll(); // 현재 위치
            int r = now[0];
            int c = now[1];
            int adjacentCnt = 0; // 인접한 바닷물의 상하좌우 카운트
            for (int i = 0; i < 4; i++) {
                int nR = r + dR[i]; // 다음으로 방문할 수 있는 위치
                int nC = c + dC[i];
                if (nR < 0 || nC < 0 || nR >= N || nC >= M) continue; // 맵을 벗어난다면 continue
                if (!check[nR][nC] && field[nR][nC] == 0) { // 방문하지 않은 바닷물을 찾으면
                    adjacentCnt++; // 카운트
                }
            }
            if (field[r][c] - adjacentCnt < 0) { // 다 녹으면
                field[r][c] = 0; // 바다가 되고
            }
            else field[r][c] -= adjacentCnt; // 아니면 녹는만큼 녹는다
        }
    }
}