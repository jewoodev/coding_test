import java.io.*;
import java.util.*;

class Main {
    private static int N; // 격자의 한 변의 길이
    private static int[][] map; // 맵 정보를 저장할 배열
    private static int[][] dSR = { // 모래가 퍼지는 곳의 행
            {-1,1,-1,1,-1,1,-2,2,0,0}, {-1,-1,0,0,1,1,0,0,2,1},
            {-1,1,-1,1,-1,1,-2,2,0,0}, {1,1,0,0,-1,-1,0,0,-2,-1}
    };
    private static int[][] dSC = { // 모래가 퍼지는 곳의 열
            {1,1,0,0,-1,-1,0,0,-2,-1}, {-1,1,-1,1,-1,1,-2,2,0,0},
            {-1,-1,0,0,1,1,0,0,2,1}, {-1,1,-1,1,-1,1,-2,2,0,0}
    };

    private static int[] dR = {0, 1, 0, -1}; // 토네이도 진행 방향
    private static int[] dC = {-1, 0, 1, 0};

    // 퍼지는 위치에 옮겨가는 모래양
    private static double[] percent = {0.01, 0.01, 0.07, 0.07, 0.1, 0.1, 0.02, 0.02, 0.05, 0};

    private static int firstAmount = 0; // 토네이도가 오기 전 모래의 총량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 맵 정보 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                firstAmount += map[i][j];
            }
        }

        tornado();
    }

    private static void tornado() {
        Queue<Sand> q = new LinkedList<>();
        int startPoint = N / 2;
        q.offer(new Sand(startPoint, startPoint, 0, 1));
        int cnt = 0; // 탐색 방향 바뀌는 횟수 저장할 변수
        while (!q.isEmpty()) {
            Sand sand = q.poll();
            int r = sand.r;
            int c = sand.c;
            int dir = sand.dir;
            int depth = sand.depth;
            cnt++;
            for (int i = 0; i < depth; i++) { // 1. 현재 위치에서 진행되어야 하는 횟수만큼
                int nR = r + dR[dir]; // 1-1. 이동
                int nC = c + dC[dir];

                // 1-3. 모래를 퍼트린다.
                flutterSand(nR, nC, dir);
                if (nR == 0 && nC == 0) { // (0, 0)에 도달하면 맵에서 벗어난 모래양을 구한다.
                    getEscapeSand();
                }
                r = nR; // depth만큼 진행해야 하므로 갱신
                c = nC;
            }
            // 탐색 방향이 2번 바뀔 때마다 진행 횟수를 1씩 up
            if (cnt % 2 == 0) depth++;
            dir++; // 토네이도대로 방향 수정
            if (dir == 4) dir = 0;
            q.offer(new Sand(r, c, dir, depth)); // 다음 탐색할 곳 저장
        }
    }



    private static void flutterSand(int r, int c, int dir) {
        int initialAmount = map[r][c];
        for (int i = 0; i < dSR[0].length; i++) {
            int nR = r + dSR[dir][i];
            int nC = c + dSC[dir][i];
            double per = percent[i];
            int flutterAmount = (int) (per * initialAmount);
            map[r][c] -= flutterAmount; // 현재 위치 모래에서 모래가 흩날린다.
            if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue; // 맵을 벗어남
            // i가 9일 때 위치하는 곳은 설명 그림의 a
            if (i == 9) {
                map[nR][nC] += map[r][c];
            }
            else {
                map[nR][nC] += flutterAmount;
            }
        }
        map[r][c] = 0; // 원래 위치의 모래는 0
    }

    private static void getEscapeSand() {
        int sum = 0; // 현재 총 모래양
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(firstAmount - sum);
        System.exit(0);
    }

    private static class Sand {
        int r, c, dir, depth; // 좌표, 방향, 진행 횟수
        private Sand(int r, int c, int dir, int depth) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.depth = depth;
        }
    }
}