import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int maxCnt = Integer.MIN_VALUE;
        int maxNum = 0;
        for (int i = 0; i < 3; i++) {
            int target = input[i];
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (target == input[j]) cnt++;
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxNum = target;
            }
        }

        int answer = 0;
        switch (maxCnt) {
            case 1:
                answer = input[2] * 100;
                break;
            case 2:
                answer = 1000 + maxNum * 100;
                break;
            case 3:
                answer = 10_000 + maxNum * 1000;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}