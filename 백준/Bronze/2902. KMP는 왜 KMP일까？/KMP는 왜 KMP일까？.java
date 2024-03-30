import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringBuilder sb = new StringBuilder();
        int l = st.countTokens();
        for (int i = 0; i < l; i++) {
            sb.append(st.nextToken().charAt(0));
        }
        System.out.print(sb);
    }
}