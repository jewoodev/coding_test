import java.io.*;
import java.util.*;

class Main {
    private static Integer[] arr;
    private static List<Integer> list;
    private static boolean[] visited;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //주어지는 수의 개수
        int m = Integer.parseInt(st.nextToken()); //수열의 길이 조건
        visited = new boolean[n];
        arr = new Integer[m];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        dfs(n, m, 0);
        bw.close();
        br.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int i : arr)
                bw.write(i + " ");
            bw.write("\n");
        } else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && before != list.get(i)) {
                    visited[i] = true;
                    arr[depth] = list.get(i);
                    before = list.get(i);
                    dfs(n, m, depth +1);
                    visited[i] = false;
                }
            }
        }
    }
}