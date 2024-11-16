import java.util.*;

class Solution {
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> fresh = new ArrayList<>(); // 신선한 오렌지 위치를 저장할 리스트

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh.add(new int[]{i, j});
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int initNum = q.size();
            while (initNum > 0) {
                initNum--;
                int[] now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nR = now[0] + dR[i];
                    int nC = now[1] + dC[i];
                    if (nR < 0 || nC < 0 || nR > m - 1 || nC > n - 1) continue;
                    if (grid[nR][nC] == 1) {
                        grid[nR][nC] = 2;
                        q.offer(new int[]{nR, nC});
                    }
                }
            }

            if (!q.isEmpty()) minute++;
        }

        for (int[] p : fresh) {
            if (grid[p[0]][p[1]] == 1) return -1;
        }
        return minute;
    }
}