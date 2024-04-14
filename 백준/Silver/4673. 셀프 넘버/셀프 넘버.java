import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) check[n] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb);
    }

    private static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10; // 첫째 자리수
            number = number / 10; // 10으로 나눠 첫 째 자리를 없앤다.
        }

        return sum;
    }
}
