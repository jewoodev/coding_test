import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a1[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a1);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(a1, target) - lowerBound(a1, target)).append(" ");
        }
        System.out.print(sb);
    }

    private static int upperBound(int[] a, int target) {
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < a[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private static int lowerBound(int[] a, int target) {
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= a[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}