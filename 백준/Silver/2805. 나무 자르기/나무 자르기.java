import java.io.*;
import java.util.*;

/*
# 요구사항 정리 #
1. 나무 M미터가 필요해서 절단기 높이를 정한 후 벌목을 해야하는 상황이다.
2. 절단기 높이 H를 정해서 주어지는 나무를 잘라냈을 때 잘라내진 나무가 적어도 M미터가 되기 위한 H의 최댓값을 구하라

# 풀이 논리 #
1. 주어지는 나무들의 길이 값이 크기 때문에 이분 탐색을 사용해 구현한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 요구사항 1번의 필요한 미터 수 M
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 주어지는 나무 길이를 배열에 저장한다.
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 저장 끝
        // 이분 탐색으로 답을 찾아서 출력.
        Arrays.sort(arr);
        System.out.print(binarySearch(arr, M, 1, arr[arr.length - 1]));
    }

    private static int binarySearch(int[] arr, int M, int start, int end) {
        int max = 0; // H의 최댓값
        while (start <= end) {
            int mid = (start + end) / 2;
            long cutting = 0;
            for (int i : arr) // H 높이로 잘라낸 나무 길이를 cutting 변수에 저장
                cutting += Math.max((i - mid), 0);
            if (cutting == M) return mid; // 잘라낸 길이가 M미터가 됐으면 최댓값이므로 리턴
            else if (cutting < M) // M미터보다 적으면 더 조금 잘라내야 하므로
                end = mid - 1; // end를 최신화
            else { // M미터보다 크면
                if (max < mid) { // 이번에 찾은 H 가 더 크다면
                    max = mid; // max 최신화.
                }
                start = mid + 1; // start를 최신화해서 더 큰 H 값을 찾는다.
            }
        }
        return max;
    }
}