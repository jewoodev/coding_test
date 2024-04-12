import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, X, answer;
    private static List<Load>[] loads, reverse;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 마을 갯수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        X = Integer.parseInt(st.nextToken()); // 도착점
        
        init(); // 맵 정보 받기
        int[] times1 = BFS(loads);
        int[] times2 = BFS(reverse);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, times1[i] + times2[i]);
        }
        
        System.out.print(answer);
    }

    private static void init() throws IOException {
        loads = new List[N + 1];
        reverse = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            loads[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int timeRequired = Integer.parseInt(st.nextToken());
            loads[start].add(new Load(end, timeRequired));
            reverse[end].add(new Load(start, timeRequired));
        }
    }

    private static int[] BFS(List<Load>[] list) {
        Queue<Load> q = new PriorityQueue<>();
        q.offer(new Load(X, 0));
        boolean[] visited = new boolean[N + 1];
        int[] times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[X] = 0;

        while (!q.isEmpty()) {
            Load now = q.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Load load : list[now.end]) {
                    if (!visited[load.end] && times[load.end] > times[now.end] + load.timeRequired) {
                        times[load.end] = times[now.end] + load.timeRequired;
                        q.offer(new Load(load.end, times[load.end]));
                    }
                }
            }
        }
        return times;
    }

    private static class Load implements Comparable<Load> {
        // 좌표 위치, 금액
        int end, timeRequired;
        private Load(int end, int timeRequired) {
            this.end = end;
            this.timeRequired = timeRequired;
        }

        @Override
        public int compareTo(Load o) {
            return this.timeRequired - o.timeRequired;
        }
    }
}
