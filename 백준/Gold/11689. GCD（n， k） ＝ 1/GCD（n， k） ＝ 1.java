import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long pi = n;
        for (long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                pi = pi - pi / i;
            }
            while(n % i == 0) {
                n /= i;
            }

        }
        if (n != 1) {
            pi = pi - pi / n;
        }
        System.out.println(pi);
    }
}