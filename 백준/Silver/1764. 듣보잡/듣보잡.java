import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        List<String> xx = new ArrayList<>();
        for (int i = 0; i < n; i++)
            set.add(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) xx.add(s);
        }
        Collections.sort(xx);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(xx.size() + "\n");
        for (String s : xx)
            bw.write(s + "\n");
        br.close();
        bw.close();
    }
}