import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int answer = 0;
        int cnt = 0;
        int l = m - 1;
        for (int i = 1; i < l; i++) {
            if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
                cnt++;
                if (cnt == n) {
                    cnt--;
                    answer++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.print(answer);
    }
}