import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long gcd = gcd(b, a);
        for (long i = 0; i < gcd; i++) {
            bw.write('1');
        }
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}