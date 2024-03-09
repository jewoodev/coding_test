import java.io.*;
import java.util.StringTokenizer;

public class Main { //P237 문제 42. 최소공배수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmpA = a;
            int tmpB = b;
            int rest = 1;
            int gcd; //gcd는 최대공약수
            if (a == 1 || b == 1) {
                sb.append(a > b ? a : b + "\n");
                continue;
            }
            while (true) {
                rest = tmpB % tmpA;
                tmpB = tmpA;
                if (rest == 0) {
                    gcd = tmpA;
                    break;
                }
                tmpA = rest;
            }
            sb.append(a * b / gcd + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}