import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 센서의 갯수
        int k = Integer.parseInt(br.readLine()); // 집중국의 갯수

        // 집중국 갯수 >= 센서 갯수 이면, 0을 출력하고 종료한다.
        if (k >= n) {
            System.out.println(0);
            return;
        }

        // 센서 좌표를 배열에 저장
        st = new StringTokenizer(br.readLine());
        int[] sensorArr = new int[n];
        for (int i = 0; i < n; i++) {
            sensorArr[i] = Integer.parseInt(st.nextToken());
        }

        // 주어진 좌표들을 순서대로 배치하기 위해 정렬
        Arrays.sort(sensorArr);

        // 좌표 끼리의 차이를 배열에 저장해서
        Integer[] diffArr = new Integer[n - 1];
        for(int i = 0; i < n - 1; i++)
            diffArr[i] = sensorArr[i + 1] - sensorArr[i];

        // 내림차순으로 정렬한다.
        Arrays.sort(diffArr, Collections.reverseOrder());

        // 차이 배열의 k-1 ~ 마지막 까지의 합을 출력한다.
        int sum = 0;
        for(int i = k - 1; i < n - 1; i++) {
            sum += diffArr[i];
        }
        System.out.println(sum);
    }
}
