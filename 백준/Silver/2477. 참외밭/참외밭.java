import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxWidthI = 0, maxWidth = 0, maxHeight = 0, maxHeightI = 0, d;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            //가장 긴 가로의 길이와 위치 찾기
            if((d == 1 || d == 2) && maxWidth < arr[i]) {
                maxWidth = arr[i];
                maxWidthI = i;
            }
            //가장 긴 세로의 길이와 위치 찾기
            else if((d == 3 || d == 4) && maxHeight < arr[i]){
                maxHeight = arr[i];
                maxHeightI = i;
            }
        }

        int right, left, minWidth, minHeight;

        //가장 긴 가로 변의 양쪽 변 길이의 차가 작은 사각형의 세로 변의 길이
        if (maxWidthI + 1 == 6) left = 0;
        else left = maxWidthI + 1;

        if (maxWidthI - 1 == -1) right = 5;
        else right = maxWidthI - 1;
        //빈 사각형의 세로 길이
        minHeight = Math.abs(arr[right] - arr[left]);

        //같은 논리로 작은 사각형의 가로 변의 길이를 연산
        if (maxHeightI + 1 == 6) left = 0;
        else left = maxHeightI + 1;

        if (maxHeightI - 1 == -1) right = 5;
        else right = maxHeightI - 1;
        //빈 사각형의 가로 길이
        minWidth = Math.abs(arr[right] - arr[left]);

        System.out.println(((maxWidth * maxHeight) - (minHeight * minWidth)) * n);
    }
}