import java.io.*;
import java.util.*;

class Main {
    private static int start, end;
    private static List<Bridge>[] list;
    private static boolean[] visited;
    private static int position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 섬 개수
        int M = Integer.parseInt(st.nextToken()); // 다리 개수
        list = new List[N + 1]; // 인접 리스트 생성
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int low = 0; // 무게 하한값
        int high = 0; // 무게 상한값
        // 인접 정보 저장
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Bridge(end, weight));
            list[end].add(new Bridge(start, weight));
            high = Math.max(high, weight);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 시작 섬
        end = Integer.parseInt(st.nextToken()); // 목표 지점
        position = 0; // 목표 지점까지 갈 수 있는지 확인할 값

        while (low <= high) {
            int mid = (low + high) / 2; // 이번에 탐색할 무게
            position = 0;
            visited = new boolean[N + 1]; // 방문 여부 체크
            DFS(start, end, mid); // 시작 섬부터 목표 지점까지 탐색
            if (position != 0) low = mid + 1; // 도달 가능하면 무게 업
            else high = mid - 1; // 아니면 다운
        }
        System.out.println(high);
    }

    private static void DFS(int start, int end, int mid) {
        if (start == end) { // 도달 가능하면
            position = end;
            return; // 리턴
        }
        visited[start] = true; // 방문 처리해주고
        for (Bridge bridge : list[start]) { // 현재 위치에서 건널 다리들을 확인
            if (!visited[bridge.end] && mid <= bridge.weight) // 방문 안했고 지금 무게가 다리의 중량 제한을 만족하면
                DFS(bridge.end, end, mid); // 건넌당께
        }
    }

    private static class Bridge {
        int end, weight;
        private Bridge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}