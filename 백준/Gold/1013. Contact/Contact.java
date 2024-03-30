import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class Main {
    private static final Pattern p = Pattern.compile("(100+1+|01)+");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            if (p.matcher(br.readLine()).matches()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}