import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 같은 색의 뿌요가 상하좌우로 4개 이상 연결되면 터진다. (1번)
2. 터진 뿌요 위의 뿌요들은 아래로 떨어지는데, 1번의 현상이 다시 일어난다. (2번)
3. 위의 논리대로 터지는 횟수를 세어 출력하라.

# 풀이 논리 #
1. BFS로 상하좌우를 탐색해서 터트린다.
2. 각 열마다 맨 아래 층부터 뿌요를 찾아서 큐에 담고 FIFO로 맨 아래층부터 채운다.
3. 1, 2 번의 작업을 지나서 이번 차례에 터진게 확인되면 1, 2번의 작업을 되풀이한다.
*/

class Main {
    private static char[][] field = new char[12][6];
    private static int bomb = 0; // 연쇄 카운트
    private static boolean isBomb = false; // 연쇄 여부
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 필드 정보 저장
        for (int r = 0; r < 12; r++) {
            String str = br.readLine();
            for (int c = 0; c < 6; c++) {
                field[r][c] = str.charAt(c);
            }
        }

        while (true) {
            isBomb = false;
            BFS(); // BFS로 조건에 맞는 뿌요를 없앤다
            drop(); // 없어진 뿌요 위에 있는 뿌요들을 떨어뜨린다
            if (isBomb == false) break; // 더 이상 연쇄가 일어나지 않을 때 break
            bomb++; // 한번에 일어난 연쇄를 한번으로 센다
        }
        System.out.print(bomb);
    }

    private static void BFS() {
        Queue<Puyo> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (field[r][c] != '.' && !visited[r][c]) { // 1. 방문하지 않은 뿌요를 찾았다!
                    List<int[]> list = new ArrayList<>(); // 같은 색의 뿌요를 담을 리스트
                    q.offer(new Puyo(r, c, field[r][c]));
                    list.add(new int[] {r, c});
                    visited[r][c] = true;
                    while (!q.isEmpty()) {
                        Puyo p = q.poll(); // 현재 확인하는 뿌요
                        for (int i = 0; i < 4; i++) {
                            int nR = p.r + dR[i]; // 다음으로 방문할 수 있는 행
                            int nC = p.c + dC[i]; // 열

                            if (nR < 0 || nC < 0 || nR >= 12 || nC >= 6) continue; // 1-1. 필드 밖이면 continue
                            if (!visited[nR][nC] && field[nR][nC] == p.color) { // 1-2. p에 인접한 뿌요가 방문되지 않았고 같은 색이면
                                visited[nR][nC] = true;
                                list.add(new int[] {nR, nC}); // 1-3. list에 담아주고
                                q.offer(new Puyo(nR, nC, field[nR][nC])); // 1-4. 다음 확인할 뿌요로 추가한다.
                            }
                        }
                    }
                    // 같은 색이 4개 이상 확인 되었으면
                    if (list.size() >= 4) {
                        for (int i = 0; i < list.size(); i++) {
                            int x = list.get(i)[0]; // 확인된 뿌요를 모두
                            int y = list.get(i)[1];
                            field[x][y] = '.'; // 터트린다
                            isBomb = true; // 연쇄 여부 체크
                        }
                    }
                }
            }
        }
    }

    private static void drop() {
        for (int c = 0; c < 6; c++) {
            Queue<Puyo> q = new LinkedList<>();
            // 가장 아래층부터 뿌요를 꺼내서 큐에 저장하고
            for (int r = 11; r >= 0; r--) {
                if (field[r][c] != '.') {
                    q.offer(new Puyo(r, c, field[r][c]));
                    field[r][c] = '.';
                }
            }
            // FIFO로 가장 아래층부터 채워나간다
            int idx = 11;
            while (!q.isEmpty()) {
                Puyo p = q.poll();
                field[idx][c] = p.color;
                idx--;
            }
        }
    }

    private static class Puyo {
        int r, c;
        char color;
        private Puyo(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
}
