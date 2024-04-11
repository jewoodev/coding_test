import java.util.*;
import java.io.*;

public class Main {
    // 검정 블록, 무지개 블록, 빈 칸
    private static int BLACK = -1, RAINBOW = 0, EMPTY = -99;
    static int N, M, sum;	// 격자 크기, 색상 개수, 점수 합
    static int[][] map;	// 격자
    static int[] dR = {-1, 0, 1, 0}, dC = {0, 1, 0, -1};	// 상 우 하 좌
    static boolean[][] visited;	// 방문 배열

    public static void main(String[] args) throws Exception {
        init(); // 입력

        solution(); // 풀이

        printResult(); // 결과 출력
    }

    static void solution() {
        while (true) {
            // 1. 크기가 가장 큰 블록 크룹을 찾는다.
            Block standardBlock = findMaxBlockGroup();
            // 더 이상 블록 그룹이 없는 경우
            if (standardBlock == null) {
                return;
            }

            // 점수 합산
            sum += standardBlock.sum * standardBlock.sum;

            // 2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다.
            removeBlock(standardBlock);

            // 3. 격자에 중력이 작용한다.
            applyGravity();

            // 4. 격자가 90도 반시계 방향으로 회전한다.
            rotateMap();

            // 5. 다시 격자에 중력이 작용한다.
            applyGravity();
        }
    }

    private static Block findMaxBlockGroup() {
        visited = new boolean[N][N];
        Block maxBlock = new Block(0, 0, EMPTY, Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 검정 블록이면 skip
                if (map[r][c] == BLACK) continue;

                // 무지개 블록이면 skip
                if (map[r][c] == RAINBOW) continue;

                // 비어있으면 skip
                if (map[r][c] == EMPTY) continue;

                // 이미 방문했으면 skip
                if (visited[r][c]) continue;

                // bfs 탐색 전에 무지개 블록만 방문 처리 초기화
                initRainBowVisited();

                Block cur = BFS(r, c, map[r][c]);

                // 그룹 블록 수 2개보다 작으면 skip
                if (cur == null) {
                    continue;
                }
                // 최대 블록 수 갱신
                if (maxBlock.compareBlock(cur)) {
                    maxBlock = cur;
                }
            }
        }

        // 초기값 그대로라면 블록그룹 못찾았으므로 null return
        if (maxBlock.color == EMPTY) {
            return null;
        }
        return maxBlock;
    }

    // 무지개 블록만 방문 처리 초기화 -> 다른 색깔의 블록에서도 무지개 블록은 방문할 수 있으므로
    static void initRainBowVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == RAINBOW) {
                    visited[i][j] = false;
                }
            }
        }
    }

    // r, c 좌표부터 같은 color 블록 bfs 탐색
    private static Block BFS(int r, int c, int color) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        visited[r][c] = true;
        int sum = 1;
        int rainbowSum = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nR = p.r + dR[i];
                int nC = p.c + dC[i];

                // 범위 나가면 skip
                if (checkRange(nR, nC)) continue;

                // 검정 블록이면 skip
                if (map[nR][nC] == BLACK) continue;

                // 비어있으면 skip
                if (map[nR][nC] == EMPTY) continue;

                // 이미 방문했으면 skip
                if (visited[nR][nC]) continue;

                // color 다를때 무지개 블록일때만 넣기
                if (map[nR][nC] != color) {
                    if (map[nR][nC] == RAINBOW) {
                        rainbowSum++;
                        sum++;
                        visited[nR][nC] = true;
                        q.offer(new Point(nR, nC));
                    }
                    continue;
                }

                sum++;
                visited[nR][nC] = true;
                q.offer(new Point(nR, nC));
            }
        }

        // 그룹에 속한 블록의 개수가 2보다 작으면 null 리턴
        if (sum < 2) {
            return null;
        } else {
            return new Block(r, c, color, sum, rainbowSum);
        }
    }

    // 범위 체크
    private static boolean checkRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }

    // 기준 블럭과 같은 그룹 모두 제거
    private static void removeBlock(Block block) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        q.offer(new Point(block.x, block.y));
        visited[block.x][block.y] = true;
        map[block.x][block.y] = EMPTY;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nR = p.r + dR[i];
                int nC = p.c + dC[i];
                // 범위 나가면 skip
                if (checkRange(nR, nC)) continue;

                // 검정 블록이면 skip
                if (map[nR][nC] == BLACK) continue;

                // 비어있으면 skip
                if (map[nR][nC] == EMPTY) continue;

                // 이미 방문했으면 skip
                if (visited[nR][nC]) continue;

                // color 다를때 무지개 블록일때만 넣기
                if (map[nR][nC] != block.color) {
                    if (map[nR][nC] == RAINBOW) {
                        map[nR][nC] = EMPTY;
                        visited[nR][nC] = true;
                        q.offer(new Point(nR, nC));
                    }
                    continue;
                }

                map[nR][nC] = EMPTY;
                visited[nR][nC] = true;
                q.offer(new Point(nR, nC));
            }
        }
    }

    // 중력 작용
    private static void applyGravity() {
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (map[j][i] == BLACK) {
                    continue;
                }
                if (map[j][i] == EMPTY) {
                    continue;
                }
                moveBlock(j, i);
            }
        }
    }

    // 블록 한개씩 옮기기
    private static void moveBlock(int r, int c) {
        int cR = r;
        while (true) {
            cR++;
            // 범위 벗어나면 break
            if (cR >= N) break;
            
            // 검정 블록이면 break;
            if (map[cR][c] == BLACK) break;
            
            // 빈 칸 아니면 break;
            if (map[cR][c] != EMPTY) break;
        }
        cR--;

        // 안움직였으면 return
        if (cR == r) {
            return;
        }

        map[cR][c] = map[r][c];
        map[r][c] = EMPTY;
    }

    // 90도 반시계 방향으로 격자 회전
    static void rotateMap() {
        int[][] mapCopied = new int[N][N];
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                mapCopied[c][r] = map[r][N - c - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = mapCopied[i][j];
            }
        }
    }

    // 결과 출력
    static void printResult() {
        System.out.println(sum);
    }

    // 입력
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 블록 클래스
    static class Block {
        // 기준 블록의 x y 좌표, 색상, 블록그룹의 총 블록 수, 블록그룹에 속한 무지개 블록 수
        int x, y, color, sum, rainbowSum;

        public Block(int x, int y, int color, int sum, int rainbowSum) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.sum = sum;
            this.rainbowSum = rainbowSum;
        }

        public boolean compareBlock(Block other) {
            // 나보다 other이 max이면 true

            // 블록 수로 비교
            if (this.sum != other.sum)
                return this.sum < other.sum;

            // 무지개 블록 수로 비교
            if (this.rainbowSum != other.rainbowSum)
                return this.rainbowSum < other.rainbowSum;

            // 행으로 비교
            if (this.x != other.x)
                return this.x < other.x;

            // 행으로 비교
            return this.y < other.y;
        }
    }

    private static class Point {
        int r, c;
        private Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}