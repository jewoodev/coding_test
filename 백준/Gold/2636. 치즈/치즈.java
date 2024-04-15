import java.util.*;
import java.io.*;

/*
(0, 0)부터 BFS 해서 치즈 모서리를 만날 때마다 값을 2로 바꿔 녹이는 방법으로 로직을 구성한다.
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static List<Integer> cheese = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new boolean[row][col];

        init();

        boolean flag = false;
        int time = 0;
        int initialCnt = countCheese();

        while (!flag) {
            time++;
            BFS(new Point(0, 0));

            for (int r = 0; r < row; r++) {
                Arrays.fill(visited[r], false);
            }

            int cnt = countCheese();
            if (cnt == 0) flag = true;
            else cheese.add(cnt);
        }

        sb.append(time).append("\n");

        if (cheese.size() > 0)
            sb.append(cheese.get(cheese.size() - 1));
        else sb.append(initialCnt);
        System.out.println(sb);
    }

    static void init() throws IOException {
        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void BFS(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visited[point.r][point.c] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];

                if (nR < 0 || nC < 0 || nR >= row || nC >= col) continue;
                if (!visited[nR][nC]) {
                    if (map[nR][nC] == 1) { // 치즈 모서리를 일단 2로 바꾼다
                        map[nR][nC] = 2;
                        visited[nR][nC] = true;
                    }
                    else if (map[nR][nC] == 0) {
                        visited[nR][nC] = true;
                        q.offer(new Point(nR, nC));
                    }
                }
            }
        }

        removeCheese(); // 2로 만든 치즈 모서리를 녹여 없앤다.
    }

    static int countCheese() {
        int cnt = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 1) cnt++;
            }
        }
        return cnt;
    }

    static void removeCheese() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 2) map[r][c] = 0;
            }
        }
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
