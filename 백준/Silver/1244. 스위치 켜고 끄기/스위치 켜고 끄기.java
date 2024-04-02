import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 주어지는 스위치 정보의 개수
        boolean[] arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1; // 배열에 주어지는 스위치 정보 저장
        }

        int M = Integer.parseInt(br.readLine()); // 주어지는 학생 수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken()); // 성별값 1: 남, 2: 여
            if (sex == 1) { // 남학생은
                int num = Integer.parseInt(st.nextToken()); // 학생에게 주어지는 스위치 번호
                for (int j = 0; j < N / num; j++) {
                    arr[num * (j + 1) - 1] = !arr[num * (j + 1) - 1]; // 주어지는 번호의 배수들의 스위치 값을 뒤집는다
                }
            }
            else { //여학생은
                int num = Integer.parseInt(st.nextToken()); // 학생에게 주어지는 스위치 번호
                num -= 1; // 인덱스 번호를 맞추는 연산
                int seq = 1;
                while (true) {
                    if (num - seq >= 0 && num + seq < N && arr[num - seq] == arr[num + seq]) { //좌우 대칭이면서 가장 많은 스위치를 포함하는 구간을 list에 저장
                        arr[num - seq] = !arr[num - seq];
                        arr[num + seq] = !arr[num + seq];
                    } else break;
                    seq++;
                }
                arr[num] = !arr[num];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] ? 1 : 0).append(" ");
            if ((i + 1) % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);
    }
}