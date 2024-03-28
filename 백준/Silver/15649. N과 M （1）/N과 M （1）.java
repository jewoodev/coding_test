import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt(); //수열의 가장 큰 수
        int m = sc.nextInt(); //수열의 길이
        arr = new int[m];
        visited = new boolean[n];
        dfs(n, m, 0);
        bw.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}