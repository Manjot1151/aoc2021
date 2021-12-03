package solutions.daythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/daythree"));
        int[] freq = new int[12];
        int count = 0;
        while (in.hasNextLine()) {
            count++;
            String bits = in.nextLine();
            for (int i = 0; i < bits.length(); i++) {
                if (bits.charAt(i) == '1')
                    freq[i]++;
            }
        }
        String gamma = "", epsilon = "";
        for (int i : freq) {
            if (i > count / 2) {
                gamma += '1';
                epsilon += '0';
            } else {
                gamma += '0';
                epsilon += '1';
            }
        }
        System.out.println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }
}
