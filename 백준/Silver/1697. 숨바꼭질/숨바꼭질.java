import java.io.*;
import java.util.*;

class Main {
//    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static boolean[] visited;
    private static int[] moveArr;
//    private static int[] dR = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
        moveArr = new int[100_001]; // 해당 지점까지 이동하는데 걸린 시간을 저장하는 배열
        visited = new boolean[100_001]; // 방문 여부 체크 배열
        BFS();
        System.out.println(moveArr[K]);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N); // 시작 정점을 큐에 넣고
        visited[N] = true; // 시작 정점을 방문 처리
        while (!q.isEmpty()) {
            int start = q.poll(); // 이번에 방문한 정점
            for (int i = 0; i < 3; i++) {
                int nR; // 현재 좌표에서 이동할 수 있는 행
                if (i == 0) nR = start * 2;
                else if (i == 1) nR = start + 1;
                else nR = start - 1;
                if (nR < 0 || nR > 100_000 || visited[nR]) continue; // 이동이 불가능 여부와 방문 여부 확인
                visited[nR] = true; // 위 조건을 통과하면 방문하고
                moveArr[nR] = moveArr[start] + 1; // 이동 횟수 처리
                if (nR == K) return; // 동생을 찾았으면 return
                q.offer(nR); // 다음 방문할 정점으로 지정
            }
        }
    }
}