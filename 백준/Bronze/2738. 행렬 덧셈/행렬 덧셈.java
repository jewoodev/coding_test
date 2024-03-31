import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        //두 개의 루프에서 A, B 에 행렬을 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        //행렬 덧셈 연산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(A[i][j] + B[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}