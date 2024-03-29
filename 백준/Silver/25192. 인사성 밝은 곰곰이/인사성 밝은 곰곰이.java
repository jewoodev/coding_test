import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean enter = false;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set.clear();
                enter = true;
                continue;
            }
            if (enter && !set.contains(s)) {
                cnt++;
                set.add(s);
            }
        }
        System.out.print(cnt);
    }
}