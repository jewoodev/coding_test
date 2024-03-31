import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] idx = new int[2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int elem = Integer.parseInt(st.nextToken());
                if (max < elem) {
                    max = elem;
                    idx[0] = i + 1;
                    idx[1] = j + 1;
                }
            }
        }
        bw.write(max + "\n");
        bw.write(idx[0] + " " + idx[1]);
        bw.close();
        br.close();
    }
}