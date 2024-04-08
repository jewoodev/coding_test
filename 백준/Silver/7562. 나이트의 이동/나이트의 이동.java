import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 체스판 한 변의 길이와 나이트의 현재 위치, 이동하려는 위치가 주어진다.
2. 최소 몇 번만에 이동할 수 있는지 구하라.

# 풀이 논리 #
1. 현재 위치에서 BFS해서 최소 이동 횟수를 구한다.
*/

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int length, T, sR, sC, eR, eC;
    private static boolean[][] visited;
    private static int[][] moveArr;
    private static int[] dR = {-2, -2, 2, 2, -1, -1, 1, 1};
    private static int[] dC = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        for (int i = 0; i < T; i++) {
            length = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            visited = new boolean[length][length]; // 방문 처리 배열
            moveArr = new int[length][length]; // 나이트 이동 횟수 저장 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            sR = Integer.parseInt(st.nextToken()); // 시작 위치의 행
            sC = Integer.parseInt(st.nextToken()); // 시작 위치의 열
            st = new StringTokenizer(br.readLine());
            eR = Integer.parseInt(st.nextToken()); // 도착 위치의 행
            eC = Integer.parseInt(st.nextToken()); // 도착 위치의 열
            BFS(sR, sC);
            sb.append(moveArr[eR][eC]).append(""\n"");
        }
        System.out.println(sb);
    }

    private static void BFS(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c)); // 시작 정점을 큐에 넣고
        visited[r][c] = true; // 시작 정점을 방문 처리
        while (!q.isEmpty()) {
            Point p = q.poll(); // 이번에 방문한 정점
            for (int i = 0; i < 8; i++) {
                int nR = p.r + dR[i]; // 현재 좌표에서 이동할 수 있는 행
                int nC = p.c + dC[i]; // 열
                if (nR < 0 || nR >= length || nC < 0 || nC >= length) continue; // 이동이 불가능한지 확인
                if (visited[nR][nC]) continue; // 방문 여부 체크
                visited[nR][nC] = true; // 위 조건을 통과하면 방문하고
                moveArr[nR][nC] = moveArr[p.r][p.c] + 1; // 이동 횟수 처리
                q.offer(new Point(nR, nC)); // 다음 방문할 정점으로 지정
            }
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
