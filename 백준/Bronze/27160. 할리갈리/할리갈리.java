import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int nCnt = Integer.parseInt(st.nextToken());
            int pCnt = 0;
            if (map.containsKey(fruit)) pCnt = map.get(fruit);
            map.put(fruit, pCnt + nCnt);
        }
        if (map.containsValue(5)) System.out.print("YES");
        else System.out.print("NO");
    }
}