import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        swap(a, 0, a.length - 1);
        swap(b, 0, b.length - 1);
        int i1 = Integer.parseInt(String.valueOf(a));
        int i2 = Integer.parseInt(String.valueOf(b));
        System.out.print(i1 > i2 ? i1 : i2);
    }

    private static void swap(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}