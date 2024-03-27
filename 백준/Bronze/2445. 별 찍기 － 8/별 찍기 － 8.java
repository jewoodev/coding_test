import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                sb.append("*");
            for (int j = 0; j < 2 * (n - i); j++)
                sb.append(" ");
            for (int j = 0; j < i; j++)
                sb.append("*");
            sb.append("\n");
        }
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++)
                sb.append("*");
            for (int j = 0; j < 2 * (n - i); j++)
                sb.append(" ");
            for (int j = 0; j < i; j++)
                sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}