package dayone;

import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        while (in.hasNextInt()) {
            int temp = in.nextInt();
            if (temp > n)
                cnt++;
            n = temp;
        }
        in.close();
        System.out.println(cnt);
    }
}