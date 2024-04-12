import java.util.*;
import java.io.*;

public class Main {
    private static int N, K, answer = 0;
    private static int[] arr;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 원생 수
        K = Integer.parseInt(st.nextToken()); // 조의 갯수
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getMinCost();
        System.out.print(answer);
    }

    // K개의 조에 대해 티셔츠 만드는 비용의 합의 최소값을 구하는 메서드
    private static void getMinCost() {
        for (int i = 1; i < N; i++) {
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);

        for (int i = 0; i < N - K; i++) {
            answer += list.get(i);
        }
    }
}