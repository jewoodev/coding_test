import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0;
        double mul = 0; //학점 * 등급 값
        Map<String, Double> map = new HashMap<>();
        init(map);
        for (int i = 0; i < 20; i++) {
            String[] line = br.readLine().split(" ");
            if (line[2].equals("P"))
                continue;
            total += Double.parseDouble(line[1]);
            mul += map.get(line[2]) * Double.parseDouble(line[1]);
        }
        System.out.print(mul / total);
    }

    private static void init(Map map) {
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
    }
}