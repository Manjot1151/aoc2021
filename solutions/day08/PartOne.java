package solutions.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day08"));
        int count = 0;
        while (in.hasNextLine()) {
            String[] digits = in.nextLine().split(" \\| ")[1].split(" ");
            for (String digit : digits) {
                if (List.of(2, 4, 3, 7).contains(digit.length()))
                    count++;
            }
        }
        System.out.println(count);
    }
}
