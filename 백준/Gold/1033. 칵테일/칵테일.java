import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<cNode>[] al;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        al = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<cNode>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            al[a].add(new cNode(b, p, q));
            al[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }
        for (int i = 0; i < n; i++) {
            bw.write(d[i] / mgcd + " ");
        }
        bw.close();
        br.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (cNode i : al[node]) {
            int next = i.getB();
            if (!visited[next]) {
                d[next] = d[node] * i.getQ() / i.getP();
                dfs(next);
            }
        }
    }

    private static class cNode {
        int b;
        int p;
        int q;

        public cNode(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}