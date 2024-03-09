import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { //P260 문제46. 특정 거리의 도시 찾기
    private static int[] visited;
    private static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        a = new ArrayList[n + 1];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
        }
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }
        bfs(x);
        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) answer.add(i);
        }
        if (answer.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(answer);
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node]++;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (Integer i : a[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}