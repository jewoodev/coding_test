import java.io.*;
import java.util.StringTokenizer;

public class Main { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        br.close();
        int[] a = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (a[i] == 0) continue;
            for (int j = i+i; j <= n; j+=i) { //배수 지우기
                a[j] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (a[i] != 0) sb.append(a[i]).append("\n");
        }
        System.out.println(sb);
    }
}