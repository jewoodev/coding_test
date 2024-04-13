import java.io.*;
import java.util.*;

/*
# 점화식 #
    1  2  3  4  5  6  7  8  9  10
1   1  1  1  1  1  1  1  1  1  1
2   1  2  2  3  3  4  4  5  5  6
5   1  2  2  3  4  5  6  7  8  9

dp += dp[i - coin[j]]
 */

public class Main {
    private static int n, k;
    private static int[] coin; // 사용할 수 있는 동전을 저장할 배열
    private static List<Integer> dp = new ArrayList<>(); // 경우의 수를 저장할 리스트
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 동전 종류
        k = Integer.parseInt(st.nextToken()); // 만들어야 하는 가치의 합

        init(); // 동전 값 배열 p에 저장
        solve();
    }

    private static void init() throws IOException {
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        dp.add(0);
        for (int i = 0; i < k; i++) {
            dp.add(0);
        }

        dp.set(0, 1);

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp.set(j, dp.get(j) + dp.get(j - coin[i]));
            }
        }
        System.out.print(dp.get(k));
    }
}
