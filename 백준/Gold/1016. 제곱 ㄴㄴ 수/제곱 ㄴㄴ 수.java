import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main { /* P227 문제 40. 제곱이 아닌 수 찾기 */
    /* 책보고 풀다가 풀이 원리가 이해 안가서 구글링하다가 문제에서 답을 주고 있다는 걸 깨달았다. */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        boolean[] check = new boolean[(int) (Max - Min + 1)];

        for (long i = 2; i <= Max; i++) {
            long pow = i * i;
            if (pow > Max) break; /* 이 연산으로 시간초과를 없앨 수 있었다. 높은 수의 곱연산이 백준 채첨서버에 시간초과를 일으키는듯 */
            long start_index = Min / pow;
            if (Min % pow != 0) start_index++;
            for (long j = start_index; pow * j <= Max; j++) {
                check[(int) ((j * pow) - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!check[i]) count++;
        }
        System.out.println(count);
    }
}