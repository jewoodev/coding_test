import java.io.*;
import java.util.*;

class Main {
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        arr = rotate(arr, R);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    private static int[][] rotate(int[][] arr, int R) {
        int cnt = Math.min(N, M) / 2; // 회전하는 라인 수
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < cnt; j++) {
                int temp = arr[j][j];
                for (int k = j + 1; k < M - j; k++) { // top
                    arr[j][k - 1] = arr[j][k];
                }
                for (int k = j + 1; k < N - j; k++) { // right
                    arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
                }
                for (int k = M - 2 - j; k >= j; k--) { // bottom
                    arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
                }
                for (int k = N - 2 - j; k >= j; k--) { //left
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }
        return arr;
    }
}