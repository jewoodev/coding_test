import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static List<Path>[] paths;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paths = new List[N + 1];

        init();
        Dijkstra();

        System.out.println(cost[N]);
    }

    private static void init() throws IOException {
        for (int i = 1; i <= N; i++) {
            paths[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            paths[start].add(new Path(end, cost));
            paths[end].add(new Path(start, cost));
        }

        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
    }

    private static void Dijkstra() {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        cost[1] = 0;
        pq.offer(new Path(1, 0));

        while (!pq.isEmpty()) {
            Path now = pq.poll();

            for (Path next : paths[now.end]) {
                if (cost[next.end] > cost[now.end] + next.cost) {
                    cost[next.end] = cost[now.end] + next.cost;
                    pq.offer(new Path(next.end, cost[next.end]));
                }
            }
        }
    }

    private static class Path implements Comparable<Path> {
        int end, cost;
        private Path(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return this.cost - o.cost;
        }
    }
}
