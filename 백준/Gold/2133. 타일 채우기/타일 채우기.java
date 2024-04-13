import java.util.*;
import java.io.*;

/*
N이 짝수일 때 타일로 채울 수 있다.
# 점화식 #
1. (이전 짝수 번째 경우의 수) 에 곱하기 3을 하고
2. (전전 번째 경우의 수) * (이전 번째에서 새로 생기는 경우의 수) * (해당 위치에서 새로 생기는 경우의 수)를 더해준다.
 */

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] tile;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tile = new int[N + 1];
        tile[0] = 1;

        for (int i = 2; i <= N; i+=2) {
            tile[i] = tile[i - 2] * 3;

            for (int j = i - 4; j >= 0; j-=2) {
                tile[i] += tile[j] * 2;
            }
        }

        System.out.println(tile[N]);
    }
}