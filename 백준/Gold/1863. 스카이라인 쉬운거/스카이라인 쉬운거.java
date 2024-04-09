import java.io.*;
import java.util.*;

class Main {
//    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 주어질 라인 수
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 불필요한 x 값
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) continue;
            stack.push(y);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() > 0) answer++;
            stack.pop();
        }
        System.out.println(answer);
    }

//    private static class Point {
//        int x, y;
//        private Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}