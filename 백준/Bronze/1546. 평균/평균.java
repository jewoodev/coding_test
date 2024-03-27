import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] g = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            g[i] = Double.parseDouble(st.nextToken());

        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (g[i] > max) max = g[i];
        for (int i = 0; i < n; i++)
            g[i] = g[i] / max * 100;
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += g[i];
        System.out.print(sum / n);
    }
}