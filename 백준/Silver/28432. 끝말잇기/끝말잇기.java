import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<String>();
        int n = Integer.parseInt(br.readLine());
        int idx = -1;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(!"?".equals(word)) set.add(word);
            else idx = i;
            arr[i] = word;
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (n == 1) {
                System.out.println(word);
                break;
            }
            if (set.contains(word)) continue;
            if (idx == 0) {
                if (arr[idx + 1].charAt(0) == word.charAt(word.length() - 1)) {
                    System.out.println(word);
                    break;
                }
            }
            else if (idx == n - 1) {
                String prev = arr[idx - 1];
                if (prev.charAt(prev.length() - 1) == word.charAt(0)) {
                    System.out.println(word);
                    break;
                }
            }
            else {
                if (arr[idx + 1].charAt(0) == word.charAt(word.length() - 1)
                        && arr[idx - 1].charAt(arr[idx - 1].length() - 1) == word.charAt(0)) {
                    System.out.println(word);
                    break;
                }
            }
        }
    }
}