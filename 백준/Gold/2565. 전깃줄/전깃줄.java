import java.io.*;
import java.util.*;

public class Main {
    private static int n, answer;
    private static int[][] wire;
    private static int[] dp;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        init(); // 전봇대 연결 정보 배열에 저장
        solve();
    }

    private static void init() throws IOException {
        dp = new int[n];
        wire = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1; // 최소 개수인 1로 초기화

            /*
             i번째 전봇대를 기준으로 이전의 전봇대들의
             전선을 연결하기 위한 탐색
             즉, i번째 전봇대에 연결된 B전봇대는
             탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함
             */
            for (int j = 0; j < i; j++) {
                if (wire[i][1] > wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }
}