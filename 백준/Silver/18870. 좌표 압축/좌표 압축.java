import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    /*
    * 1. 수직선 위의 좌표 갯수 N, 공백으로 구분된 X 좌표들을 xArr배열로 입력 받음
    * 2. xArr 배열을 깊은 복사한 원본 배열 생성
    * 3. xArr를 오름차순 정렬 후 HashMap에 저장해서 중복 제거
    * 4. 원본 배열과 HashMap을 비교해서 해당 키에 대응하는 값 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 수직선 위의 좌표 갯수

        // 두 번째 줄에 있는 입력값들을 StringTokenizer를 사용하여 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xArr = new int[N]; // 입력 받은 X 좌표 배열
        for (int i = 0; i < N; i++) {
            // StringTokenizer로 분리된 토큰들을 정수로 변환 후에 xArr 배열에 저장
            xArr[i] = Integer.parseInt(st.nextToken());
        }

        // X좌표 배열을 복제한 원본 배열 생성
        int[] originalArr = xArr.clone();

        // X좌표 배열을 오름차순 정렬
        Arrays.sort(xArr);

        // X좌표 배열의 각 요소를 키로 갖고, 해당 키의 인덱스를 값으로 갖는 HashMap을 생성
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // HashMap에 해당 키가 없는 경우에만 키-값 쌍을 추가
            if (!map.containsKey(xArr[i])) {
                map.put(xArr[i], index++);
            }
        }
        // 원본 배열의 각 요소에 대해 HashMap에서 해당 키에 대응하는 값을 출력
        for (int i = 0; i < N; i++) {
            sb.append(map.get(originalArr[i])).append(" ");
        }
        System.out.println(sb);
    }
}