/*
# 요구사항 정리 #
1. N개의 정수로 이루어진 수열의 부분 수열 중, 크기가 양수이면서 그 수열의 원소의 총 합이 S가 되는 경우의 수를 구하라.

# 풀이 논리 #
1. 각 원소를 수열에 포함하거나(1), 하지 않거나(2) 두 가지 선택지를 가지도록 부분 수열을 만드는 로직을 구성한다.
2. 만들어진 부분 수열의 합이 S가 될 때마다 카운트한다.
3. S가 0 인 경우 공집합도 카운트되므로 정답에서 -1 해준다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int N, S, cnt;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        cnt = 0; // 부분 수열의 개수
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);
        if (S == 0) System.out.print(cnt - 1); // 풀이 논리 3번
        else System.out.print(cnt);
    }

    private static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S) cnt++; // 풀이 논리 2번
            return;
        }
        DFS(depth + 1, sum + arr[depth]); // 풀이 논리 1번의 (1)
        DFS(depth + 1, sum); // 풀이 논리 2번의 (2)
    }
}
