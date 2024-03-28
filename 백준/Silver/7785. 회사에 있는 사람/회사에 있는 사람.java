import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String eol = st.nextToken();
            if (eol.equals("leave"))
                map.remove(name);
            else map.put(name, 0);
        }
        List<String> names = new ArrayList<>(map.keySet());
        Collections.sort(names, Collections.reverseOrder());
        for (String name : names)
            bw.write(name + "\n");
        bw.close();
        br.close();
    }
}