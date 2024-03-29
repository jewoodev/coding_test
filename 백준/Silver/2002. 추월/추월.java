import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String out = br.readLine();
            arr[i] = map.get(out);
        }
        int l = n - 1;
        int answer = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}