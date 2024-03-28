import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Set<String> diffS = new HashSet<>();
        String s = sc.next();
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                diffS.add(s.substring(i, j));
            }
        }
        System.out.print(diffS.size());
    }
}