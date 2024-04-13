import java.io.*;

/*
전체 전선 개수 - 설치 가능 개수 로 철거해야 하는 전선의 개수를 구한다.

1. 설치 가능한 전선 갯수를 세어야 한다. i 번째 A 전봇대에 연결된 B 전봇대보다
    이전의 A 전봇대에 연결된 B 전봇대의 값이 작을때 
    i번째의 전선과 교차되지 않는다는 점에 초점을 맞춘다.   
2. A전봇대 기준으로 i번째에 연결된 전깃줄을 잇고 i번째 이전의 전선들을 확인하면서
    i번째에 연결된 B의 값보다 작은 것을 모두 세는 작업을 Bottom-Up 방식으로 진행한다.
*/

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
