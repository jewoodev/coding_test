import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String[] dow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int day = 0;
        for (int i = 0; i < x - 1; i++) {
            day += months[i];
        }
        day += y - 1;
        System.out.print(dow[day%7]);
    }
}