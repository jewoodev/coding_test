import java.io.*;
import java.util.*;

class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] chessBoard = new char[N][M];
        for (int i = 0; i < N; i++) {
            chessBoard[i] = br.readLine().toCharArray();
        }
        
        int minChanges = Integer.MAX_VALUE;
        // 시작점을 변경하면서 8x8 체스판 생성
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                char[][] subBoard = new char[8][8];
                for (int k = 0; k < 8; k++) {
                    System.arraycopy(chessBoard[i + k], j, subBoard[k], 0, 8);
                }
                // 맨 왼쪽 위 칸이 'B'일 때 변경 횟수 계산
                minChanges = Math.min(minChanges, getMinChanges(subBoard, 'B'));
                // 맨 왼쪽 위 칸이 'W'일 때 변경 횟수 계산
                minChanges = Math.min(minChanges, getMinChanges(subBoard, 'W'));
            }
        }
        
        bw.write(String.valueOf(minChanges));
        bw.flush();
    }

    // 체스판의 특정 색깔로 시작할 때 변경해야 할 최소 칸 수 계산
    private static int getMinChanges(char[][] chessBoard, char startColor) {
        int changes = 0;
        // 시작 색과 같은 색으로 시작하지 않는 칸 수 계산
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && chessBoard[i][j] != startColor)
                    changes++;
                else if ((i + j) % 2 == 1 && chessBoard[i][j] == startColor)
                    changes++;
            }
        }
        return changes;
    }
}
