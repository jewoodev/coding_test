import java.util.*;
import java.io.*;

/*
스티커를 떼면 그 아래와 좌우, 혹은 그 위와 좌우 스티커가 사용할 수 없게된다.
그러면서 더 두 변을 공유하지 않아야 한다.
스티커의 숫자 각각이 다르니까
왼쪽 대각선(이전 쪽으로, 왼쪽)과 그 왼쪽 스티커 숫자를 비교해서 더 큰 값을
해당 위치에 더해가는 식으로 연산한다.
 */

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // initialize
            int[][] stickers = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            // 첫번째 column은 자기 자신이 최대이므로 자기 자신으로 초기화
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
