import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26]; //영문자 개수를 저장할 배열
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) //대문자면
                arr[s.charAt(i) - 65]++; //해당 범위에 맞는 연산
            else
                arr[s.charAt(i) - 97]++;
        }
        int max = Integer.MIN_VALUE;
        char c = '0';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                c = (char) (i + 65);
            } else if (arr[i] == max) {
                c = '?';
            }
        }
        System.out.print(c);
    }
}