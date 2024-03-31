import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int horizon = 0; // 가로 개수
        int vertical = 0; // 세로 개수
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }
        // 가로, 세로 방향으로 누울 수 있는지 여부
        for (int i = 0; i < N; i++) {
            int check_h = 0, check_v = 0;
            for (int j = 0; j < N; j++) {
                // 가로 체크
                if (room[i][j] == '.') check_h++;
                if (room[i][j] == 'X' || (j == N - 1)) {
                    if (check_h >= 2) horizon++;
                    check_h = 0;
                }
                // 세로 체크
                if (room[j][i] == '.') check_v++;
                if (room[j][i] == 'X' || (j == N - 1)) {
                    if (check_v >= 2) vertical++;
                    check_v = 0;
                }
            }
        }
        bw.write(horizon + " " + vertical);
        bw.close();
        br.close();
    }
}