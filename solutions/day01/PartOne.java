package solutions.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day01"));
        int num = in.nextInt();
        int cnt = 0;
        while (in.hasNextInt()) {
            int temp = in.nextInt();
            if (temp > num)
                cnt++;
            num = temp;
        }
        System.out.println(cnt);
    }
}