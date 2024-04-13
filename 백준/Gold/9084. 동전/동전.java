import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int T, N, M;
    private static int[] coin;
    private static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            init();
            solve();
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine()); // 동전의 가지 수
        coin = new int[N]; // 동전 금액이 담기는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine()); // 만들려는 금액
    }

    private static void solve() {
        dp.add(0);
        for (int i = 0; i < M; i++) {
            dp.add(0);
        }

        dp.set(0, 1);

        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                dp.set(j, dp.get(j) + dp.get(j - coin[i]));
            }
        }
        sb.append(dp.get(M)).append("\n");
        dp.clear();
    }
}